FROM openjdk:17
EXPOSE 8080
WORKDIR /SimpleApp
ADD spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]
