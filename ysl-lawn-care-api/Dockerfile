# Stage 1: Build the Java application
FROM maven:3.9.5-eclipse-temurin-21 AS build 
WORKDIR /app
# Copy the pom.xml file first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline
# Copy the rest of the source code
COPY src ./src
# Package the application into a single JAR file
RUN mvn clean install -DskipTests

# Stage 2: Create the final image (minimal size for deployment)
FROM eclipse-temurin:21-jre-alpine 
WORKDIR /app
# Copy the built JAR file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar
# The command to run the Java application
ENTRYPOINT ["java", "-jar", "app.jar"]