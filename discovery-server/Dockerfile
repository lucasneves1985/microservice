FROM openjdk:17
EXPOSE 8761
ADD ./target/discovery-server-1.0.jar discovery-server.jar
ENTRYPOINT ["java","-jar","/discovery-server.jar"]