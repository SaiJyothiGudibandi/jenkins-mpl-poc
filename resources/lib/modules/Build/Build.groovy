sh "echo 'Construindo imagem do Docker'"
sh "docker build -t ${CFG.imagem_builder} -f Dockerfile.builder ."
sh "docker build --build-arg BUILDER=${CFG.imagem_builder} -t ${CFG.imagem} -f Dockerfile ."