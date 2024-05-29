FROM gradle:7.3.1-jdk17-alpine AS builder
ARG JAR_FILE=build/libs/*.jar
WORKDIR /build
COPY ${JAR_FILE} hotel-api.jar
ENTRYPOINT ["java", "-jar", "hotel-api.jar"]