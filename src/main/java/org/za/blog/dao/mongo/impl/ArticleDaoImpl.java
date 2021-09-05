package org.za.blog.dao.mongo.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;
import org.za.blog.utils.PageResult;

@Repository
@Primary
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements IArticleDao {
    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    @Override
    public PageResult<Article> findByPage(Integer pageNum, Integer pageSize) {
        PageResult<Article> pageResult = new PageResult<>();
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setTotal(mgt.count(new Query(), Article.class));
        Query pageQuery = new Query();
        pageQuery.skip((long) (pageNum - 1) * pageSize);
        pageQuery.limit(pageSize);
        pageResult.setList(mgt.find(pageQuery, Article.class));

        return pageResult;
    }
}
