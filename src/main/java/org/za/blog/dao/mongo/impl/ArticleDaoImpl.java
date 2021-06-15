package org.za.blog.dao.mongo.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;

@Repository
@Primary
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements IArticleDao {
    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
