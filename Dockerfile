FROM maven:3.9.8-eclipse-temurin-22-alpine as build
COPY . .
RUN mvn -f pom.xml clean -DskipTests=true package
FROM eclipse-temurin:22
COPY --from=build /accounts-app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]