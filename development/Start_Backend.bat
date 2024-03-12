@echo off

REM Build and run the Spring Boot application
cd ../backend/
echo Building the backend...
call mvn clean install
echo Starting the backend...
java -jar target/com.jugglehive.backend.jar