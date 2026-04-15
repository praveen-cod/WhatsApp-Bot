FROM eclipse-temurin:latest

WORKDIR /app

ENV JAVA_TOOL_OPTIONS="-XX:+UseContainerSupport"

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/whatsapp-bot-0.0.1-SNAPSHOT.jar"]