# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
EXPOSE  8888

ADD ./target/springboot-servicio-config-server-0.0.1-SNAPSHOT.jar config-server.jar

ENTRYPOINT ["java", "-jar", "config-server.jar"]

