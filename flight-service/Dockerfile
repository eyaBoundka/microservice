FROM  openjdk:11
EXPOSE 8083
ADD /target/flight-service-0.0.1-SNAPSHOT.jar flight-service.jar
ENTRYPOINT ["java", "-jar", "flight-service.jar"]