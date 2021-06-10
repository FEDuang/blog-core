package com.za.blogcore.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Setter
public class Account {
    private Integer uid;

    private String username;

    private String password;

    private Date createdTime;

}