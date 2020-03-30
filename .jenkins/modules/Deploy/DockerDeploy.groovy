/**
 * Deploy the built Docker images
 */

// Registering decommissioning poststep
MPLPostStep('always') {
  echo "Docker Deploy Decomission poststep"
}

sh "sudo docker push mlptest"

sh "docker stop \$(docker ps -a -q)"
sh "docker rm \$(docker ps -a -q)"
sh "docker run --name mynginx1 -p 80:80 -d mlptest"
