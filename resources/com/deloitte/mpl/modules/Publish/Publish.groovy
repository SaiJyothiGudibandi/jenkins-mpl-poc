sh "echo 'Publicando a imagem'"
sh "aws ecr get-login --no-include-email --region us-east-1 | sh"
sh "docker push ${CFG.imagem}"