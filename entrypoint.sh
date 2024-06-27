#!/bin/sh
JVM_OPTS="\
    -Xms${JVM_XMS:-256}m \
    -Xmx${JVM_XMX:-256}m \
    -Xss${JVM_XSS:-512}k \
    -XX:MaxMetaspaceSize=${JVM_METASPACE:-290}m \
    -Djava.security.egd=file:/dev/urandom \
    "

java $JVM_OPTS $JVM_CUSTOM -jar /app.jar
