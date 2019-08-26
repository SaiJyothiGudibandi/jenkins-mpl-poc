@Library('mpl') _

def call(){

    MPLInit()
    
    pipeline {
        agent {
            label 'ec2'
        }

        stages {

            stage('Checkout'){
                steps{
                    MPLModule('Git Checkout', CFG)
                }
            }

            stage('Build'){
                steps {
                    MPLModule('Build', CFG)
                }
            }
        }
    }
}