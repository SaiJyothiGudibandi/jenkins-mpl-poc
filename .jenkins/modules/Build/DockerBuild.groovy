def call(sudo = true) {

  prefix = ""
  if (sudo) {
    prefix = "sudo "
  }
  echo "Docker build started"
  sh """${prefix}docker image build -t mlptest ."""
  sh "docker build -t mlptest ."
  echo "build completed"
  sh """${prefix}docker login -u mlptest"""
  sh """${prefix}docker image push mlptest"""

  extraTags.each { t ->
    sh """${prefix} docker tag mlptest mlptests"""
    sh """${prefix} docker push mlptests"""
  }

}