FROM openjdk:17
EXPOSE 8222
ADD ./target/api-gateway-server-1.0.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]