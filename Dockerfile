FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

ENV DEBIAN_FRONTEND noninteractive

WORKDIR /build/ml-platform

COPY pom.xml /build/ml-platform/pom.xml
COPY src /build/ml-platform/src
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:21.0.1_12-jre-alpine

VOLUME /tmp

COPY entrypoint.sh entrypoint.sh
COPY --from=build /build/ml-platform/target/*.jar app.jar

ENTRYPOINT ["/entrypoint.sh"]
