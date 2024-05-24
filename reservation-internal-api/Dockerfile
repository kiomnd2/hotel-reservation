FROM bellsoft/liberica-openjdk-alpine:17 AS builder
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder ${JAR_FILE} reservation-api.jar
ENTRYPOINT ["java", "-jar", "reservation-api.jar"]