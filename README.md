# FirstRestAPI

Task 2 for the Java course at Vistula University.
Author: Danylo Kholodtsov, 76822

## About

This is a simple REST API for products, made with Spring Boot. You can create, read, update and delete products. Each product has an id and a name. The data is saved in an H2 in-memory database, so it is cleared every time the app is restarted.

The project uses Java 17, Spring Boot 4.1.2, Spring Data JPA, H2 and Swagger (springdoc).

## How to run

Start the app with the Maven wrapper:

```
mvnw.cmd spring-boot:run
```

On Linux or macOS use ./mvnw spring-boot:run instead. You can also run the FirstRestApiApplication class from IntelliJ IDEA.

The app starts on http://localhost:8080.

## How to use

All endpoints are under /api/v1/products.

POST /api/v1/products creates a new product. Send JSON like {"name": "Laptop"}.

GET /api/v1/products returns all products.

GET /api/v1/products/{id} returns one product by its id.

PUT /api/v1/products/{id} changes the name of a product. Send JSON like {"name": "New name"}.

DELETE /api/v1/products/{id} deletes a product.

If a product with the given id does not exist, the API returns 404 with a message like "Product with 5 not found".

The easiest way to try the API is Swagger UI at http://localhost:8080/swagger-ui/index.html.

You can see the database in the H2 console at http://localhost:8080/console. Use the JDBC URL jdbc:h2:mem:testdb.
