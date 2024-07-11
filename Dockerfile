FROM openjdk:17
EXPOSE 8080
WORKDIR /SimpleApp
COPY *.jar spring-boot-starter-parent.jar
ENTRYPOINT ["java", "-jar", "spring-boot-starter-parent.jar"]
