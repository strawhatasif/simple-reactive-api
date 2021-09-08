### A simple reactive API

* This project uses Spring WebFlux.

### Users endpoints

* It calls one API (https://jsonplaceholder.typicode.com/) and returns fake user data.
* Two endpoints - one for getting a collection of users and another for retrieving specific user data.

### Albums endpoint
* One endpoint to retrieve a collection of fake albums from a public API (https://jsonplaceholder.typicode.com/)
* A circuit breaker (implemented with `Resilience4J`) handles failing over the service call when a service is unavailable/returning errors.

### Testing the API
* `gradlew bootRun` or `./gradlew bootRun` to run the API
* Invoke the API using your favorite API testing tool (OR, in the browser!). 
    * I prefer Postman
    * `GET` all users - `http://localhost:8080/users/`
    * `GET` one user - `http://localhost:8080/users/{id}`
    * `GET` all albums - `http://localhost:8080/albums`