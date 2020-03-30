
/**
 * Basic MPL pipeline
 * Shows pipeline with basic stages and modules of the MPL library
 *
 * @author Sergei Parshev <sparshev@griddynamics.com>
 */
def call(body) {
    MPLInit()

    pipeline {
        agent {
            label MPL.agentLabel
        }
        options {
            skipDefaultCheckout(true)
        }
        stages {
            stage( 'Checkout' ) {
                when { expression { MPLModuleEnabled() } }
                steps {
                    MPLModule()
                }
            }
            stage( 'Build' ) {
                when { expression { MPLModuleEnabled() } }
                steps {
                    MPLModule()
                }
            }
            stage( 'Deploy' ) {
                when { expression { MPLModuleEnabled() } }
                steps {
                    MPLModule()
                }
            }
        }
        post {
            always {
                MPLPostStepsRun('always')
            }
            success {
                MPLPostStepsRun('success')
            }
            failure {
                MPLPostStepsRun('failure')
            }
            post {
                always {
                    cleanWs()
                }
            }
        }
    }
}
