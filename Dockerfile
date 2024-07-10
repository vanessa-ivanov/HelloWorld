FROM eclipse-temurin:17-jdk-focal
ADD target/SimpleApp SimpleApp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webapp-0.0.1-SNAPSHOT.jar"]
