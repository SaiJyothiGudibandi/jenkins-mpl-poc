
def call(body){
    
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){
        
        body()

        stage('Build'){
            println nomeApp
            MPLModule('Build', [])
        }
    }

}