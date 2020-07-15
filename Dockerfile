FROM openjdk:11.0.7
WORKDIR /
ADD target/kucchil-kitchen.jar kucchil-kitchen.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kucchil-kitchen.jar"]
