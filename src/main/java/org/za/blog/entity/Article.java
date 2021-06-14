package org.za.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Getter
@ToString
@Setter
public class Article {
    private Long articleId;

    private String articleTitle;

    private String articleMarkdown;

    private String articleThumbnail;

    private List<String> articleTags;

    private Date createdTime;
    
    private Date editedTime;
}
