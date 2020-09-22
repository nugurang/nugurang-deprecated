FROM azul/zulu-openjdk:14
EXPOSE 8080
RUN addgroup spring && useradd spring -g spring
ARG DEST=/srv
COPY . ${DEST}
WORKDIR ${DEST}
RUN ./gradlew --info wrapper
RUN ./gradlew --info build
USER spring:spring
ENTRYPOINT ["./gradlew","bootRun"]
