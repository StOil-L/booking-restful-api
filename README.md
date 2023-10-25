# Booking RESTful API

## Authors
[Lorenzo PUCCIO](https://github.com/StOil-L)

[Arthur SAPIN](https://github.com/a-sapin)

## Context

This project was carried out during my studies at the University of Montpellier as a first year Software Engineering Masters Degree student.

It constitutes as an assignment from the Decentralized Computing subject (subject code: HAI704I).

This RESTful API uses Spring Boot in order to publish webservices designed for a hotel booking context.

The Booking RESTful API allows the user to:
  - Log in with booking agency credentials to access an agency-exclusive discount on prices
  - Check available hotels in an area, as well as a specific hotel's rooms
  - Sort hotel rooms by ascending price
  - Book an available room during a time period of the user's choosing

## Getting Started

In order to run the project, please follow these instructions:
  - Import the project from each folder into a Java IDE of your choice (IntelliJ, Eclipse...)
    - Said IDE must offer Maven support.
    - If the imports were not resolved upon importing these projects, you can resolve them manually by running the `mvn install` Maven command line.
  - Run the REST API **server** first: you can run the entire project (`rest.exo2.demo.hotelagence`) as a Java Application. This will publish the webservices on port 8080 of `localhost`.
    - Alternatively, you can run the `HotelAgenceRestDemoApplication` class (from the `rest.exo2.demo.main` package).
  - Run the REST API **client** second: you can run the entire project (`rest.exo2.demo.hotelagence.client`) as a Java Application.
    - Alternatively, you can run the `HotelAgenceRestClientDemoApplication` class (from the `rest.exo2.demo.main` package).
  - As you're running the **client** of the REST API, the client will ask for the URI of the webservice: the URI to enter is `http://localhost:8080/agenceservice/api`.
