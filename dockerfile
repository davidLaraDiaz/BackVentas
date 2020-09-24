FROM openjdk:11
ARG PROPIEDADES_FILE=target/application.properties
COPY ${PROPIEDADES_FILE} application.properties
ARG JAR_FILE=target/DemoCurso-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} DemoCurso-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dserver.port=8085","-Dspring.config.location=application.properties","DemoCurso-0.0.1-SNAPSHOT.jar"]
