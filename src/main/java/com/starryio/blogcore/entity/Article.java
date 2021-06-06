package com.starryio.blogcore.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Setter
public class Article {

    private Long postId;

    private String postTitle;

    private String postContent;
}
