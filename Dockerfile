FROM openjdk:8

WORKDIR /

ADD build/libs/cinelux-0.0.1-SNAPSHOT.jar cinelux.jar

CMD ["java", "-jar", "cinelux.jar"]