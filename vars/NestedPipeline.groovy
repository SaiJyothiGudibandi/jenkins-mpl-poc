
def call(body){
    MPLInit()

    pipeline {
        agent {
            label 'ec2'
        }
        stages{
            stage('Build'){
                MPLModule('Build')
            }

            stage('Deploy') {
                MPLModule('Deploy')
            }
        }
    }
}