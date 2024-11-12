# Stage 1: Build the project
FROM maven:3.9.9-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

# Package the application without running tests
RUN mvn clean package -DskipTests

# Stage 2: Setup Tomcat to run the application
FROM tomcat:11.0.1-jdk21

# Remove default Tomcat web applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built war file to the Tomcat webapps directory
# Make sure this line clearly specifies the source and destination
COPY --from=build /app/target/ProjetoPraceando-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

# Expose port 8080 for the Tomcat server
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
