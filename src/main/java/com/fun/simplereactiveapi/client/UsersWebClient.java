package com.fun.simplereactiveapi.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
public class UsersWebClient {

    WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/");

    public Flux<Users> retrieveAllUsers() {
        return webClient.get()
                .uri("users")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Users.class);
    }

    public Mono<Users> retrieveOneUser(String id) {
       return webClient.get()
                .uri("users/" + id)
                .accept(APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    return clientResponse.bodyToMono(Users.class);
                });
    }
}
