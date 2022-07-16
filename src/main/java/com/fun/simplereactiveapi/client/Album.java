package com.fun.simplereactiveapi.client;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Album(String id, String userId, String title) { }
