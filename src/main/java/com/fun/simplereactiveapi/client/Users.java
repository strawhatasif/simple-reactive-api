package com.fun.simplereactiveapi.client;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Users(String id, String name, String username, String email, String phone) { }
