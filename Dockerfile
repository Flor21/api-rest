FROM adoptopenjdk:11-jre-hotspot
WORKDIR /api-rest
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run