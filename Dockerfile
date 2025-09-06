# 1. Use a base image with Java & Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# 2. Set working directory
WORKDIR /app

# 3. Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 4. Copy source and build jar
COPY src ./src
RUN mvn clean package -DskipTests

# 5. Use lightweight JDK to run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run app
ENTRYPOINT ["java","-jar","app.jar"]
