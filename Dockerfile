FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/finshot-0.0.1-SNAPSHOT.jar finshot.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","finshot.jar"]