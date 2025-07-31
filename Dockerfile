# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download Maven dependencies (offline build)
RUN ./mvnw dependency:go-offline

# Copy the entire project source
COPY . .

# Build the application (skip tests to speed up)
RUN ./mvnw package -DskipTests

# Run the JAR file
CMD ["java", "-jar", "target/ems-0.0.1-SNAPSHOT.jar"]
