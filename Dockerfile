# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests=true clean package

# Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Render injects $PORT; Spring reads it via server.port=${PORT}
ENV JAVA_TOOL_OPTIONS="-Xmx256m -XX:+UseSerialGC"
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
