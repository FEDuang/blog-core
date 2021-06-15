package org.za.blog.dao.mongo.impl;

import org.springframework.stereotype.Repository;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;

@Repository(value = "ArticleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements IArticleDao {
    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
