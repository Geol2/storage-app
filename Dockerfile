FROM openjdk:17-jdk-slim
#FROM openjdk:11
WORKDIR /D/Project/storage-app
ARG JAR_PATH=./build/libs
COPY ${JAR_PATH}/storage-0.0.1-SNAPSHOT.jar ${JAR_PATH}/storage-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","./build/libs/storage-0.0.1-SNAPSHOT.jar"]