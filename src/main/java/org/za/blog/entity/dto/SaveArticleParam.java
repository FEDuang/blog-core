package org.za.blog.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SaveArticleParam {
    private String articleId;
    private String articleTitle;
    private String articlePreview;
    private String context;
}
