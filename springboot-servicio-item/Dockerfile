# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
# Commented because the port here is random
EXPOSE  8002

ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar servicio-item.jar

ENTRYPOINT ["java", "-jar", "servicio-item.jar"]

