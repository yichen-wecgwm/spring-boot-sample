FROM adoptopenjdk:11-jre-hotspot-focal as builder
WORKDIR application
RUN java -Djarmode=layertools -jar target/*.jar extract

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
