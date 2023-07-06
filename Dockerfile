FROM adoptopenjdk:11-jdk-hotspot-focal as builder
WORKDIR application
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x mvnw && ./mvnw clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:11-jre
WORKDIR application
RUN addgroup --system springboot && adduser --system springboot --ingroup springboot
USER springboot
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
# TODO 添加启动参数
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
