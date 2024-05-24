FROM bellsoft/liberica-openjdk-alpine:17 AS builder
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]