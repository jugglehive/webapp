@echo off

REM Stop and delete the Docker Postgres container
echo Deleting the Docker Postgres container
docker stop jg-test-postgres
docker rm jg-test-postgres
docker volume rm jgtempdbdata