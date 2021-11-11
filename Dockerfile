FROM openjdk:11-jre-slim
ADD ./target/item-api-*.jar /app.jar

EXPOSE 8080
CMD java -jar app.jar