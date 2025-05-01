FROM maven:3.8.6-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean package
CMD ["java", "-jar", "target/container-routing-1.0.jar"]
