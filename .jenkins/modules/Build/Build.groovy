MPLPostStep('always') {
  junit 'target/surefire-reports/*.xml'
}

MPLModule('Build', CFG)

if( fileExists('Dockerfile') ) {
  MPLModule('Docker Build', CFG)
}