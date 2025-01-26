FROM maven:amazoncorretto AS build

WORKDIR /app

COPY pom.xml ./

#RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:17.0.13-al2023-headless

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-Xms128m", "-Xmx256m", "-jar", "/app/app.jar"]
