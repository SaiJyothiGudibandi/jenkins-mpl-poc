
def call(){
    
    MPLInit()

    node('ec2'){
        stage('Build'){
            MPLModule('Build')
        }
    }

}