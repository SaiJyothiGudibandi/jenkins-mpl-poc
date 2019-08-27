
def call(){
    MPLInit()

    pipeline {
        agent {
            label 'ec2'
        }
        stages{
            stage('Build'){
                steps{
                    MPLModule('Build')
                }
            }

            stage('Deploy') {
                steps{
                    MPLModule('Deploy')
                }
            }
        }
    }
}