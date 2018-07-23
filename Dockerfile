FROM java:8-jdk
ADD target/webhook-api.jar webhook-api.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/webhook-api.jar"]