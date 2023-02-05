# Health-Route API

## Introduction

The Health-Route application is designed to track health metrics and generate useful diagrams and
    charts that clearly display trends over time. The API provides the ability to interface with
    the Health-Route UI that will begin development shortly. The idea for Health-Route came about
    because I wanted to be able to access data about my nutritional habits, medication history,
    body-weight trends, exercise habits, and other health related metrics, from a single application;
    something not currently widely available outside of editing a spreadsheet daily.

## Implementation Details

* This API is developed in Java using the Spring Boot microservice framework
* The application is compiled via Maven and the necessary dependencies are included in the pom.xml file
* The [health-route-api.yaml](./health-route-api.yaml) file contains the OpenAPI specification for the
    Health-Route API
* URLs are routed through the classes in the [controller directory](./src/main/java/dev/joshtaylor/healthrouteapi/controller)
* The [domain directory](./src/main/java/dev/joshtaylor/healthrouteapi/domain) contains the java object models
    representing the domain objects
* The [scripts directory](./scripts) contains scripts to automatically generate mock data for the H2 in-memory
database used by the JPA repositories. To generate mock data on your local machine, run the 
[mock.sh](./scripts/mock.sh) script in a linux shell.

## Feature Roadmap

- [ ] Replace initial H2 in memory database with Postgres db
- [ ] Create db init container for Postgres db
- [ ] Add liquibase functionality for db versioning
- [ ] Deploy service to Amazon EKS 
- [ ] Manage continuous delivery and deployments through ADO pipelines
- [ ] Begin development of UI component