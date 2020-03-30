/**
 * Deploy the built Docker images
 */

sh "docker push saijyothi9/mlptest"

sh "docker stop \$(docker ps -a -q)"
sh "docker rm \$(docker ps -a -q)"
sh "docker run --name mynginx1 -p 80:80 -d saijyothi9/mlptest"
