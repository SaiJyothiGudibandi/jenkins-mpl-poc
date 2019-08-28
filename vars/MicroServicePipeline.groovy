def call(Map params){

    MPLInit
    node('ec2'){

        def myRepo = checkout scm
        def branch = myRepo.GIT_BRANCH.replace("origin/","").replace("/","-")
        def imagem = "${env.ENDPOINT_ECR}/${params.nomeApp}:v0.1.${env.BUILD_NUMBER}_${branch}_${myRepo.GIT_COMMIT}"

        stage('Build') {
            MPLModule('Build', [ imagem: imagem, nomeApp: params.nomeApp, branch: branch])
        }

        stage('Publish') {
            MPLModule('Publish', [imagem: imagem])
        }

        stage('Clean') {
            MPLModule('Clean', [imagem: imagem])
        }

        stage('Deploy') {
            MPLModule('Deploy', [imagem:imagem, rota: params.rota, branch: branch, database: params.database, volume: params.volume])
        }
    }
}