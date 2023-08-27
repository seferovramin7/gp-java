FROM openjdk:17
WORKDIR /app
COPY build/target/ms-gp.jar app.jar
CMD ["java", "-jar", "app.jar"]