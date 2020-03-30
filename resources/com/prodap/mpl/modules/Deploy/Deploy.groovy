def ambiente = ""
switch(CFG.branch){
    case "qa":
        ambiente = "qa"
        break
    case "master":
        ambiente = "prd"
        break
    default:
        ambiente = "dev"
        break
}

if(CFG.'liquibase.host'){
    MPLModule('Liquibase Deploy', CFG)
}

def host = CFG.'liquibase.host' ? CFG.'liquibase.host' : ''
withDockerContainer(image: 'bitnami/kubectl:latest', args: "--entrypoint=''"){
    withKubeConfig([credentialsId: "config-${ambiente}"]) {
        sh("sed -i.bak 's#CONNECTION_STRING_BANCO#${host}#' k8s/dev/deployment.yaml")
        sh "sed -i.bak 's#ecr/${CFG.rota}#${CFG.imagem}#' k8s/${ambiente}/deployment.yaml"
        sh "kubectl apply -f k8s/${ambiente}"
        sh "kubectl apply -f k8s/svc"
    }
}