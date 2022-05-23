FROM gradle:jdk11 as demo
COPY / /app
RUN cd /app && gradle build -x test
FROM openjdk:11-jdk-alpine
COPY --from=demo /app/build/libs/Microbus-0.0.1-SNAPSHOT.jar /app.jar
CMD java -jar /app.jar


