# Use an official OpenJDK image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# ✅ Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the project
COPY . .

# Build the application
RUN ./mvnw package -DskipTests

# Run the JAR file
CMD ["java", "-jar", "target/ems-0.0.1-SNAPSHOT.jar"]
