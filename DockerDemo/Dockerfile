# Use a lightweight JDK base image
FROM openjdk

# Set working directory
WORKDIR /app

# Copy the Spring Boot fat JAR into the container
COPY target/DockerDemo-0.0.1-SNAPSHOT.jar DockerDemo-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "DockerDemo-0.0.1-SNAPSHOT.jar"]
