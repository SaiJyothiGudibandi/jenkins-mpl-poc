
def call(body){
    
    MPLInit()

    stage('Build'){
        MPLModule('Build', [nomeApp: body.nomeApp])
    }
}