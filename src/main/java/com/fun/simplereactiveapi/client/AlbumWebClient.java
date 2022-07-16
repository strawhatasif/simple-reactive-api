package com.fun.simplereactiveapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class AlbumWebClient {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private static final Logger logger = Logger.getLogger(AlbumWebClient.class.getCanonicalName());

    public Flux<Album> getAlbums() {
        var circuitBreaker = circuitBreakerFactory.create("circuitBreaker");

        var webClient = WebClient.create("http://localhost:8080/");

        //Invoke an endpoint that always returns a 500 status code
        return circuitBreaker.run(() ->
                webClient.get()
                        .uri("albumz")
                        .accept(APPLICATION_JSON)
                        .exchangeToFlux(clientResponse -> {
                            if (HttpStatus.INTERNAL_SERVER_ERROR.equals(clientResponse.statusCode())) {
                                logger.warning("Failing back to default method to retrieve album information");
                                return getDefaultAlbumList();
                            }
                            //this is to ensure a different response when the circuit breaker works.
                            return getSingleAlbum();
                        }));
    }

    public Flux<Album> getDefaultAlbumList() {
        var webClient = WebClient.create("https://jsonplaceholder.typicode.com/");

        return webClient.get()
                .uri("albums/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Album.class);
    }

    /**
     * Just for fun! Don't do this in production!!!
     * Ideally, this should be a <pre>Mono<T></pre>.
     * @return one or more Albums.
     */
    public Flux<Album> getSingleAlbum() {
        var webClient = WebClient.create("https://jsonplaceholder.typicode.com/");

        return webClient.get()
                .uri("albums/1")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Album.class);
    }
}
