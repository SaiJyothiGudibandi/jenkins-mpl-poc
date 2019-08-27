
String nomeApp
String rota

def call(body){
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){

        def myRepo = checkout scm
        def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        def imagem = "${env.ENDPOINT_ECR}/${nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"

        stage('Build') {
            MPLModule('Build', [ imagem: imagem, nomeApp: nomeApp, branch: branch])
        }

        stage('Publish') {
            MPLModule('Publish', [imagem: imagem])
        }

        stage('Clean') {
            MPLModule('Clean', [imagem: imagem])
        }

        stage('Deploy') {
            MPLModule('Deploy', [imagem:imagem, rota: rota, branch: branch])
        }
    }
}