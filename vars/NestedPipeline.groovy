
def call(){
    MPLInit()

    node(CFG.agent) {
        
        stage('Build'){
            MPLModule('Build', CFG)
        }

        stage('Test'){
            MPLModule('Test', CFG)
        }

        stage('Deploy') {
            MPLModule('Deploy', CFG)
        }
    }
}