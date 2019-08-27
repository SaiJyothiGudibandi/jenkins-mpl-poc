
def call(Map params){
    
    library('mpl')
    MPLModulesPath('lib')

    node('ec2'){
        stage('Build'){
            MPLModule('Build', [nomeApp: params.nomeApp])
        }
    }
}