FROM bellsoft/liberica-openjdk-alpine:17 AS builder
VOLUME /tmp
WORKDIR /build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} reservation-api.jar
ENTRYPOINT ["java", "-jar", "reservation-api.jar"]