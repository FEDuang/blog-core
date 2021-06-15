package org.za.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;
import org.za.blog.service.IArticleService;

import java.util.List;

@Service
public class ArticleImpl implements IArticleService {
    IArticleDao articleDao;

    @Autowired
    public ArticleImpl(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article GetArticle(String articleId) {
        return articleDao.find(articleId);
    }

    @Override
    public List<Article> GetArticles(int limit, int page) {
        return null;
    }

    @Override
    public Article SaveArticle(Article article) {
        return null;
    }

    @Override
    public int DeleteArticle(String[] articleIds) {
        articleDao.delete(articleIds);
        return articleIds.length;
    }
}
