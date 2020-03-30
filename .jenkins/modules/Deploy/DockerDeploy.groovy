/**
 * Deploy the built Docker images
 */

sh "sudo docker push mlptest"

sh "docker stop \$(docker ps -a -q)"
sh "docker rm \$(docker ps -a -q)"
sh "docker run --name mynginx1 -p 80:80 -d mlptest"
