FROM eclipse-temurin:22

LABEL MAINTAINER = "RAKESH@GMAIL.COM"

WORKDIR     /app

COPY target/springboot-restful-crud-apis-0.0.1-SNAPSHOT.jar /app/springboot-restful-crud-apis.jar

ENTRYPOINT ["java","-jar","springboot-restful-crud-apis.jar"]

