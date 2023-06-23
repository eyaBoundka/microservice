FROM  openjdk:11
EXPOSE 8084
ADD /target/crew-service-0.0.1-SNAPSHOT.jar crew-service.jar
ENTRYPOINT ["java", "-jar", "crew-service.jar"]