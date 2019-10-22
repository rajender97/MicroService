FROM openjdk:11
WORKDIR usr/src
ADD ./target/zuul-0.0.1-SNAPSHOT.jar /usr/src/zuul-0.0.1-SNAPSHOT.jar
EXPOSE 8061
ENTRYPOINT ["java","-jar","/usr/src/zuul-0.0.1-SNAPSHOT.jar"]