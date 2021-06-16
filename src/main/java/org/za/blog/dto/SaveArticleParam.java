package org.za.blog.dto;

import lombok.Data;

@Data
public class SaveArticleParam {
    private String articleTitle;
    private String articlePreview;
    private String context;
}
