FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/BookStore-0.1.0.jar"]
