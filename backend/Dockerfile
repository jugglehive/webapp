FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY backend/target /app
#COPY backend/src/main/resources/application.properties /app/classes/application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/com.jugglehive.backend.jar"]