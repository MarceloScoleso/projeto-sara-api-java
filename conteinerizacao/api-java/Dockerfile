FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY target/sua-api.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]