FROM openjdk:17
WORKDIR /KinMKD-LocationService
COPY target/KinMKD-LocationService-0.0.1-SNAPSHOT.jar .
COPY src/main/resources/locations.json /app/locations.json
EXPOSE 8082
ENTRYPOINT ["java","-jar","KinMKD-LocationService-0.0.1-SNAPSHOT.jar"]