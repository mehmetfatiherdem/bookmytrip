# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8088

# Run the application
ENTRYPOINT ["java", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=80.0", \
    "-XX:+UseSerialGC", \
    "-XX:MaxMetaspaceSize=90m", \
    "-XX:ReservedCodeCacheSize=24m", \
    "-XX:+TieredCompilation", \
    "-XX:TieredStopAtLevel=1", \
    "-XX:CICompilerCount=2", \
    "-Xss256k", \
    "-XX:InitialCodeCacheSize=16m", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-Djava.awt.headless=true", \
    "-jar", "app.jar"]
