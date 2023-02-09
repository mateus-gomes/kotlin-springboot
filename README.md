# kotlin-springboot
A repository to store the code from "REST API's RESTFul do 0 à AWS c. Spring Boot Kotlin e Docker" course.

Para iniciar o docker com o banco de dados basta usar o comando

docker build -t kotlin-springboot-postgresql ./

docker run -d --name kotlin-springboot-postgresql -p 5432:5432 kotlin-springboot-postgresql