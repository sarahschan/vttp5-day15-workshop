# FROM eclipse-temurin:23-jdk
FROM openjdk:23-jdk


LABEL maintainer="Sarah"
LABEL description="This is the dockerisation of day 15 workshop"
LABEL project-name="vttp5a-ssf-day15-workshop"


ARG APP_DIR=/app
WORKDIR ${APP_DIR}

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src


RUN chmod a+x ./mvnw && ./mvnw clean package -Dmaven.test.skip=true


ENV SERVER_PORT 8888

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp5a-ssf-day15wsA-0.0.1-SNAPSHOT.jar