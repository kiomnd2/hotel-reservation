FROM bellsoft/liberica-openjdk-alpine:17
VOLUME /tmp
WORKDIR /build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} eureka.jar
ENTRYPOINT ["java", "-jar", "eureka.jar"]