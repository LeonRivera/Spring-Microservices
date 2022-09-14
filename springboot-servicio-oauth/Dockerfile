# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
EXPOSE  9100
ADD ./target/springboot-servicio-oauth-0.0.1-SNAPSHOT.jar servicio-oauth.jar

ENTRYPOINT ["java", "-jar", "servicio-oauth.jar"]

