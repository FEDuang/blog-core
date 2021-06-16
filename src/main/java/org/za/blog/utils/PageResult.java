package org.za.blog.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    /**
     * 页码，从1开始
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 总数
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> list;
}
