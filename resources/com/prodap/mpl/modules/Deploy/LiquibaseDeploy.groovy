def liquibaseImagem = "${env.ENDPOINT_ECR}/liquibase:latest"
def host = CFG.'liquibase.host'
def password = CFG.'liquibase.password'
def username = CFG.'liquibase.username'
def volume = CFG.'liquibase.volume' ? CFG.'liquibase.volume' : "${env.WORKSPACE}/src/db/changelogs"
def db = CFG.'liquibase.database'
def tag = CFG.'liquibase.tag'
sh "docker run --rm -v ${volume}:/changelogs -e LIQUIBASE_HOST=${host} -e LIQUIBASE_USERNAME=${username} -e LIQUIBASE_PASSWORD=${password} -e LIQUIBASE_DATABASE=${db} -e LIQUIBASE_PORT=3306 ${liquibaseImagem} cp /changelogs/* . && liquibase updateToTag ${tag}"