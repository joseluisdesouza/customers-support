FROM openjdk:11
ARG JAR_FILE=out/artifacts/customer_support_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080:8080