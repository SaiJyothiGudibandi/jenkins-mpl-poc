
def call(){
    MPLInit()

    stage('Build'){
        MPLModule('Build', CFG)
    }

    stage('Test'){
        MPLModule('Test', CFG)
    }
}