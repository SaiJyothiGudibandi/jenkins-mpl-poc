
def call(){
    MPLInit()

    stage('Build'){
        MPLModule('Build')
    }

    stage('Test'){
        MPLModule('Test')
    }
}