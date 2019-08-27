
def call(){
    MPLInit()

    node('ec2') {

        def myRepo = checkout scm
        def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        def imagem = "${env.ENDPOINT_ECR}/${CFG.nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"
        def imagem_builder = "builder_${CFG.nomeApp}_${branch}"
        
        stage('Build'){
            MPLModule('Build', CFG)
        }

        stage('Deploy') {
            MPLModule('Deploy', CFG)
        }
    }
}