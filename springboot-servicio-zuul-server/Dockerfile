# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
EXPOSE  8090
ADD ./target/springboot-servicio-zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar

ENTRYPOINT ["java", "-jar", "zuul-server.jar"]

