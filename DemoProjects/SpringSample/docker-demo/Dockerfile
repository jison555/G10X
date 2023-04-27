FROM adoptopenjdk/openjdk15
ENV APP_HOME=/usr/jison/app
WORKDIR ${APP_HOME}
COPY target/*.jar web.jar
EXPOSE 8085
CMD [“java”, “-jar”, “web.jar”]
