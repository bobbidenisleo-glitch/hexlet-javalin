FROM gradle:8.12.1-jdk21

WORKDIR /app

COPY . .

RUN ["./gradlew", "clean", "shadowJar"]

CMD ["java", "-jar", "build/libs/HexletJavalin-all.jar"]
