FROM openjdk:17
EXPOSE 8080
WORKDIR /SimpleApp
ENTRYPOINT ["java", "-jar", "/app.jar"]
