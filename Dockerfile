FROM openjdk:17.0.1-jdk-slim
COPY target/*.jar /home/app/foreigncurrency.jar
ENTRYPOINT ["java", "-jar", "/home/app/foreigncurrency.jar"]