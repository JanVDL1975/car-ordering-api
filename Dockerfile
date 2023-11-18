# Use a base image with Java 17 installed
FROM openjdk:17

# Copy the compiled JAR file into the container at /app
ADD target/carorderingproject-0.0.1.jar carorderingproject.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "carorderingproject.jar"]