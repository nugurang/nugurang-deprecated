FROM azul/zulu-openjdk:14
EXPOSE 8080
RUN addgroup spring && useradd -m spring -g spring
ARG APP_ROOT=/srv
COPY . ${APP_ROOT}
RUN chmod -R a+w ${APP_ROOT}
USER spring:spring
WORKDIR ${APP_ROOT}
RUN ./gradlew --info wrapper
RUN ./gradlew --info build
WORKDIR ${APP_ROOT}
ENTRYPOINT ["./gradlew", "bootRun"]
