/**
 * Deploy the built Docker images
 */
echo"test deploy"
//sh "docker push saijyothi9/mlptest"
sh "docker push ${params.docker_tag}"

sh "docker stop \$(docker ps -a -q)"
sh "docker rm \$(docker ps -a -q)"
sh "docker run --name mynginx1 -p 80:80 -d ${params.docker_tag}"
