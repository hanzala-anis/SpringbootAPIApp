# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/springboot-product-api-0.0.1-SNAPSHOT.jar /app/springboot-product-api-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/springboot-product-api-0.0.1-SNAPSHOT.jar"]

# Expose the port that your app runs on (default is 8080)
EXPOSE 8080
