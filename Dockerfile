FROM openjdk:23-jdk-oracle

WORKDIR /usr/src/app

COPY src/main/resources/config.yml .

COPY target/ToDOApp-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "ToDOApp-1.0-SNAPSHOT.jar", "server", "config.yml"]