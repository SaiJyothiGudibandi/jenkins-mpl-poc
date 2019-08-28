def liquibaseImagem = "${env.ENDPOINT_ECR}/liquibase:latest"
def host = "env.CONNECTION_STRING_${CFG.ambiente.toUpperCase()}"
def password =  "env.PASS_${CFG.ambiente.toUpperCase()}"
sh "docker run --rm -v ${CFG.volume} -e LIQUIBASE_HOST=${host} -e LIQUIBASE_USERNAME=jenkins -e LIQUIBASE_PASSWORD=${password} -e LIQUIBASE_PASSWORD=${CFG.database} -e LIQUIBASE_PORT=3306 ${liquibaseImagem} liquibase updateToTag 1.17"