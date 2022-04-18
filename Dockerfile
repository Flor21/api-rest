FROM adoptopenjdk:11-jre-hotspot
MAINTAINER desarrolloapirest.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-rest-1.0.1.jar
ENTRYPOINT ["java","-jar","/api-rest-1.0.1.jar"]