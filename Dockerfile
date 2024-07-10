FROM eclipse-temurin:17-jdk-focal
EXPOSE 8080
ADD spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]
