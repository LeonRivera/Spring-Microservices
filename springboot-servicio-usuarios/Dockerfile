# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
# Commented because the port here is random
# EXPOSE  8761

ADD ./target/springboot-servicio-usuarios-0.0.1-SNAPSHOT.jar servicio-usuarios.jar

ENTRYPOINT ["java", "-jar", "servicio-usuarios.jar"]

