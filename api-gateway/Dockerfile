FROM bellsoft/liberica-openjdk-alpine:17 AS builder
VOLUME /tmp
WORKDIR /build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]