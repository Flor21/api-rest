FROM maven:3.8-jdk-11
WORKDIR /api-rest
COPY . .
RUN mvn clean -U install -Dmaven.test.skip=true
CMD mvn spring-boot:run