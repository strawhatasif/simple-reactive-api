package com.fun.simplereactiveapi.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album {
    public String id;
    public String userId;
    public String title;
}
