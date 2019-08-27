
def call(body){
    
    MPLInit()

    node('ec2'){
        stage('Build'){
            MPLModule('Build')
        }
    }

}