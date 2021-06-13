package com.za.blogcore.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private Integer uid;

    private String username;

    private String password;

    private Date createdTime;

}