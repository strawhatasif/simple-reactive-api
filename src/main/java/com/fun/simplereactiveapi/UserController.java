package com.fun.simplereactiveapi;

import com.fun.simplereactiveapi.client.Users;
import com.fun.simplereactiveapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Flux<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    private Mono<ResponseEntity<Users>> getUserById(@PathVariable String id) {
        return usersService.getSingleUser(id);
    }
}
