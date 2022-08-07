# App Contact

## About The Project

App Contact is a RestFul application to manage contacts and their skills.

### Built With

This application uses this stack :

* [Maven 3.6](https://maven.apache.org/download.cgi)
* [Java 17](https://www.azul.com/downloads/?version=java-17-lts&package=jdk)
* [Spring-boot 2.7.X](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot)
* [Flyway](https://flywaydb.org/)
* [Jooq](https://www.jooq.org/)
* [PostgreSQL 13](https://www.postgresql.org/)
* [Checkstyle](https://checkstyle.sourceforge.io/)

## Getting Started

To run the application, you have several options.

### Using docker-compose

This project provide a [standalone containerization](./tools/README.md). 

### Using maven

Check the JDK version used by Maven and run :

```mvn spring-boot:run```

### Swagger

Once the application is started, the [Swagger documentation](http://localhost:8080/swagger-ui/index.html#/) is accessible

## Usage

### Curl FTW

In the absence of a front-end application, we need an HTTP client. cURL will do the job nicely to exploit the endpoints.

- Create / Update a contact 

```shell
curl -X PUT 127.0.0.1:8080/contacts/a-valid-email@gmail.com  -H 'Content-Type: application/json' -d '{
    "firstName":"firstName",
    "lastName":"lastName",
    "fullName":"fullName",
    "birthDate":"2022-08-05T20:05:24.00Z",
    "address":"address",
    "mobilePhoneNumber":"0123456789"}' -v
```

- Get a contact

```shell
curl -X GET http://localhost:8080/contacts/a-valid-email@gmail.com -v
```

- Delete a contact

```shell
curl -X DELETE http://localhost:8080/contacts/a-valid-email@gmail.com -v
```

- Add / Update a contact's skill

```shell
curl -X POST 127.0.0.1:8080/contacts/a-valid-email@gmail.com/skills  -H 'Content-Type: application/json' -d '[{
    "name":"development", "level":"EXPERT"}]'
```

- Get a contact's skill

```shell
curl -X GET http://localhost:8080/contacts/a-valid-email@gmail.com/skills -v
```

- Delete a contact's skill

```shell
curl -X DELETE http://localhost:8080/contacts/a-valid-email@gmail.com/skill/development -v
```

## Roadmap

This project was implemented from scratch in a few hours, so the quality is not production-ready :
- [x] Add checkstyle ;
- [x] Add Flyway migration ;
- [x] Add Jooq generation ;
- [x] Add Contacts API and basic business logic ;
- [x] Test the business logic ;
- [x] Add Swagger documentation ;
- [ ] Test controllers and repositories ;
- [ ] Add Auth0 Authentication / Authorization ;
- [ ] Add Test-container to launch the tests in standalone ;
- [ ] Add an init-data to help developers get familiar with the product ;
- [ ] Create a front-end application to integrate the APIs ;
- [ ] Add Feature Toggle to prepare the Go Live and get feedback from beta user ;
- [ ] Set up a continuous integration with a distributed SaaS solution ;
- [ ] Improve architecture with a redundant database solution (and hourly backup) ;
- [ ] Add Sonar tools to detect flaws on PRs and bump master dependencies version ;
- [ ] Collect logs with a pod agent and exploit it (Datadog, Kibana, etc) ;
- [ ] Add an alert mechanism to inform support about errors (Sentry) ;
- [ ] Create a dashboard of metrics to monitor feature usage and identify congestion ;
- [ ] Add some business metrics with Prometheus / Actuator ;
- [ ] A lot more to come, we can add new features, datastores, technologies, Dev-ops tools...

## License

Distributed under the MIT License. See `LICENSE` for more information.