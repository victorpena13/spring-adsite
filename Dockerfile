FROM openjdk:8
ADD target/adlist-0.0.1-SNAPSHOT.jar adlist-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "adlist-0.0.1-SNAPSHOT.jar"]