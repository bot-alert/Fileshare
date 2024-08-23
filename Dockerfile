# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/fileshare-*.jar /app/fileshare.jar

# Expose the port the application will run on
EXPOSE 8080

# Set the entrypoint for the container to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/fileshare.jar"]
