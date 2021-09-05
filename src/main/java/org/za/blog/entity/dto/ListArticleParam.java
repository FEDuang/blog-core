package org.za.blog.entity.dto;

import lombok.Data;

@Data
public class ListArticleParam {
    private int pageSize;
    private int pageNum;
}
