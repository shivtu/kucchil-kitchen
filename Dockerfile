FROM openjdk:11.0.7 
WORKDIR /
ADD /target/kcchil-kitchen.jar kcchil-kitchen.jar
EXPOSE 8080
CMD java - jar kcchil-kitchen.jar
