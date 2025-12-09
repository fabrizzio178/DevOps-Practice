# Imagen con j21
FROM eclipse-temurin:21-jdk-alpine
# variable que encuentra el archivo jar (el ejecutable que genera java cuando compila)
ARG JAR_FILE=target/*.jar
# Copia el jar del proyecto a la imagen y lo renombra como app.jar
COPY ${JAR_FILE} app.jar
# nuestro comando de inicio
ENTRYPOINT ["java", "-jar", "/app.jar"]