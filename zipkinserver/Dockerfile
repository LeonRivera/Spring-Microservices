# Image based
FROM openjdk:8

# Logs directory
VOLUME /tmp

# port of publishing
EXPOSE  9411

ADD ./zipkin-server-2.23.18-exec.jar zipkin-server

ENTRYPOINT ["java", "-jar", "zipkin-server"]

