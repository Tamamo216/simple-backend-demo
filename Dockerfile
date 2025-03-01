FROM eclipse-temurin:21-jdk-alpine-3.21
WORKDIR /app
COPY target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]