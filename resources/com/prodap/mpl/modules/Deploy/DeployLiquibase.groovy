def liquibaseImagem = "${env.ENDPOINT_ECR}/liquibase:latest"
def host = CFG.'liquibase.host'
def password = CFG.'liquibase.password'
def username = CFG.'liquibase.username'
def volume = CFG.'liquibase.volume' ? CFG.'liquibase.volume' : 'fonte/db/changelogs'
def db = CFG.'liquibase.database'
def tag = CFG.'liquibase.tag'
sh "docker run --rm -v ${volume} -e LIQUIBASE_HOST=${host} -e LIQUIBASE_USERNAME=${username} -e LIQUIBASE_PASSWORD=${password} -e LIQUIBASE_PASSWORD=${db} -e LIQUIBASE_PORT=3306 ${liquibaseImagem} liquibase updateToTag ${tag}"