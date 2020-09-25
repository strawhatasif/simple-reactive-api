### A simple reactive API

* This API uses Spring WebFlux.
* It calls one API (https://jsonplaceholder.typicode.com/) and returns fake user data.
* 2 endpoints - one for getting a collection of users and another for retrieving specific user data.

### Testing the API
* `gradlew bootRun` or `./gradlew bootRun` to run the API
* Invoke the API using your favorite API testing tool (OR, in the browser!). 
    * I prefer Postman
    * `GET` all users - `http://localhost:8080/users/`
    * `GET` one user - `http://localhost:8080/users/{id}` 