def call(String project, String hubUser) {
  sh "docker build -t=${params.docker_tag} ."
  withCredentials([usernamePassword(
          credentialsId: "saijyothi9",
          usernameVariable: "USER",
          passwordVariable: "PASS"
  )]) {
    sh "docker login -u '$USER' -p '$PASS'"
  }
  // sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
  // sh "docker push ${params.docker_tag}"
}