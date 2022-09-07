FROM amazoncorretto:8-al2-jdk AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build --exclude-task test

FROM amazoncorretto:8
WORKDIR /app
EXPOSE 8080
ENV USE_HTTPS=false
ENV TZ=Asia/Seoul
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /app/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "/app/app.jar"]