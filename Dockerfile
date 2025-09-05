# Step 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests=true clean package

# Step 2: Run the JAR with Java
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
