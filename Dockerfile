# 1. java 설치
FROM openjdk:11-jdk as builder
ARG JAR_FILE=build/libs/app.jar
# 2. 소스 복사
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar","/app.jar" ]
EXPOSE 8081