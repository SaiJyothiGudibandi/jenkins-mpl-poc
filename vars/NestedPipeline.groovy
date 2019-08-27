
def call(Map params){
    
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){

        def myRepo = checkout scm
        def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        def imagem = "${env.ENDPOINT_ECR}/${params.nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"
        def image_builder = "builder_${params.nomeApp}_${branch}"

        stage('Build') {
            MPLModule('Build', [
                imagem: imagem,
                imagem_builder: image_builder
            ])
        }

        stage('Publish') {
            MPLModule('Publish', [imagem: imagem])
        }

        stage('Clean') {
            MPLModule('Clean', [imagem: imagem])
        }

        stage('Deploy') {
            MPLModule('Deploy')
        }
    }
}