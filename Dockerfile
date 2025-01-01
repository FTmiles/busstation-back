# Use official Java 21 image as base
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the JAR file into the container (it will be built in the CI/CD pipeline or local build)
COPY ./build/libs/busstation-backend.jar /app/app.jar

# Set the command to run the JAR file
CMD ["java", "-jar", "app.jar"]

# Expose the port your Spring Boot app is running on (default is 8080)
EXPOSE 8080
