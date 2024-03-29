package com.fun.simplereactiveapi.service;

import com.fun.simplereactiveapi.client.Users;
import com.fun.simplereactiveapi.client.UsersWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UsersService {

    @Autowired
    private final UsersWebClient usersWebClient;

    public UsersService(UsersWebClient usersWebClient) {
        this.usersWebClient = usersWebClient;
    }

    public Flux<Users> getAllUsers() {
        return usersWebClient.retrieveAllUsers();
    }

    public Mono<ResponseEntity<Users>> getSingleUser(String id) {
        return usersWebClient.retrieveOneUser(id)
                .map(response -> (StringUtils.hasText(response.email()) ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(response) :
                       ResponseEntity.status(HttpStatus.OK).body(response)));
    }
}
