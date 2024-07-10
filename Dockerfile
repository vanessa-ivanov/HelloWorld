FROM openjdk:17
EXPOSE 8080
WORKDIR /SimpleApp
ADD out/artifacts/simpleApp_jar/simpleApp.jar /simpleApp.jar
ENTRYPOINT ["java", "-jar", "/simpleApp.jar"]
