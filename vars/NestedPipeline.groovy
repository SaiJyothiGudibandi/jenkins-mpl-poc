
def call(Map CFG){
    MPLInit()

    node(CFG.agent_label) {

        // def myRepo = checkout scm
        // def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        // def imagem = "${env.ENDPOINT_ECR}/${nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"
        // def imagem_builder = "builder_${nomeApp}_${branch}"
        
        stage('Build'){
            MPLModule('Build', CFG)
        }

        stage('Deploy') {
            MPLModule('Deploy', CFG)
        }
    }
}