def call(sudo = true, extraTags = []) {

  prefix = ""
  if (sudo) {
    prefix = "sudo "
  }
  sh """${prefix} docker image build \
        -t Test-Jenkins-MPL ."""

  sh """${prefix} docker login"""

  sh """${prefix} docker image push \
        Test-Jenkins-MPL"""

}