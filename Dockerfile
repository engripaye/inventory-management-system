# Use lightweight Java 21 runtime
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/inventory-service-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
