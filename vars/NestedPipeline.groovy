
public String nomeApp
public String rota

def call(body){
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){

        def myRepo = checkout scm
        def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        def imagem = "${env.ENDPOINT_ECR}/${this.nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"

        stage('Build') {
            MPLModule('Build', [ imagem: imagem, nomeApp: this.nomeApp, branch: branch])
        }

        stage('Publish') {
            MPLModule('Publish', [imagem: imagem])
        }

        stage('Clean') {
            MPLModule('Clean', [imagem: imagem])
        }

        stage('Deploy') {
            MPLModule('Deploy', [imagem:imagem, rota: this.rota, branch: branch])
        }
    }
}