package com.fun.simplereactiveapi.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

    public String id;
    public String name;
    public String username;
    public String email;
    public String phone;
}
