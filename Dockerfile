FROM oracle/graalvm-ce:latest
COPY ./target/SGRU-0.0.1-SNAPSHOT.jar  /
WORKDIR /
VOLUME /tmp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","SGRU-0.0.1-SNAPSHOT.jar"]
