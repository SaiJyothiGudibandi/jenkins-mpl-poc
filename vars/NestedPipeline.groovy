
def call(body){
    
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){
        stage('Build'){
            println body.nomeApp
            MPLModule('Build', [])
        }
    }

}