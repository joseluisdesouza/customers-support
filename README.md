### Bem-vindo(a) ao meu projeto!👋🏽

#### Teste pratico - Resolvedores de Incidentes

### ✅Tecnologias usadas para realizar o projeto
As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/)  
- [Docker](https://docs.docker.com/desktop/windows/install/)

- ### Pré requisitos

- ### Docker
    docker -v\
    Docker version 20.10.12, build e91ed57
- ### Java 11
    java --version\
    Java(TM) SE Runtime Environment 18.9 (build 11.0.12+8-LTS-237)

### Peço desculpas mas não consegui subir a aplicação com o docker, infelizmente tive um problema que devido ao tempo não consegui resolver
### O ideal seria clonar o repositorio e startar normalmente

### git clone https://github.com/joseluisdesouza/customers-support.git
## - Clone em uma pasta de sua escolha
## - Abra o projeto em uma ide
## - Acesse http://localhost:8080/swagger-ui/index.html#/ ou se prefirir usar um Postman ou Insomnia

### Link Postman https://www.postman.com/downloads/
### Link Insomnia https://insomnia.rest/download

### Construir imagem
    docker build -t customer-support .
### Subir aplicação
    docker run -p 8080:8080 customer-support
### Swagger
    http://localhost:8080/swagger-ui/index.html#/

Esta API contem dois endpoints sendo eles:
### orderedSearch() - GET ​/resolvers/im-day
### findAllPaginated() - GET ​/resolvers
