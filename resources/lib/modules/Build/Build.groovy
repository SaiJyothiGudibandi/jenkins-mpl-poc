def builder = "builder_${CFG.nomeApp}_${CFG.branch}"
sh "echo 'Construindo imagem do Docker'"
sh "docker build -t ${builder} -f Dockerfile.builder ."
sh "docker build --build-arg BUILDER=${builder} -t ${CFG.imagem} -f Dockerfile ."