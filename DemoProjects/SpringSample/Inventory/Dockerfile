FROM adoptopenjdk/openjdk15
ENV APP_HOME=/usr/jison/app
WORKDIR ${APP_HOME}
COPY target/*.jar app.jar
EXPOSE 8081
CMD [“java”, “-jar”, “app.jar”]
