FROM openjdk:17
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app-contact.jar
ENTRYPOINT ["java", "-jar", "app-contact.jar"]
