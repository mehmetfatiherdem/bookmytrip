# Use an OpenJDK image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/bookmytrip-service-discovery-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8761

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]