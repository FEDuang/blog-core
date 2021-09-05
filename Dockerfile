FROM java:8
VOLUME /root/tmp

COPY ./libs/blog-core-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c "touch /app.jar"

ENTRYPOINT ["java", "-jar", "app.jar"]