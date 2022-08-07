# Docker

## Dependencies

- The app-contact application requires a [PostgreSQL 13](https://hub.docker.com/_/postgres/) database

## Package the application 

### Prerequisite

This project uses [JDK 17](https://www.azul.com/downloads/?version=java-17-lts&package=jdk).
Make sure your [Maven](https://maven.apache.org/download.cgi) executable uses the right Java version :

```mvn --version```

### Steps
To containerize the application, it is first necessary to package it.

Run the following command at the root of the project :

```mvn clean package```

This should have built a jar: target/app-contact-X.Y.Z.jar

The build should now be copied to the containerization folder :

```cp target/app-contact-X.Y.Z.jar tools/docker/```

## Run it

To manage docker images, we use [Docker Compose](https://docs.docker.com/compose/install/).
It will detect the spring boot application and its postgres dependency.
Environment variables are directly injected into the application, no additional configuration is required.

Docker compose exposes port 8080 of the application, so the local use is not affected
(see the application's [README.md](../README.md))

- The command line startup is done directly in the docker folder :

```mv tools/docker/```

- To start the program and its dependencies (we force the regeneration of the image to refresh the jar) :

```docker-compose up --build```

- It is also possible to launch postgres alone in order to run the program with other tools

```docker-compose up -d postgres```

- To shut down the program :

```docker-compose down```
