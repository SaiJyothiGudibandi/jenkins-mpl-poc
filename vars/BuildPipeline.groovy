
def call(){
    MPLInit()

    stage('Build'){
        MPLModule()
    }

    stage('Test'){
        MPLModule()
    }
}