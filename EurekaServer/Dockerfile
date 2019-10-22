FROM openjdk:11
WORKDIR usr/src
ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar /usr/src/EurekaServer-0.0.1-SNAPSHOT.jar
EXPOSE 8062
ENTRYPOINT ["java","-jar","/usr/src/EurekaServer-0.0.1-SNAPSHOT.jar"]