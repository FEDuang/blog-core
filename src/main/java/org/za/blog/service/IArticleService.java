package org.za.blog.service;

import org.za.blog.entity.Article;

import java.util.List;

public interface IArticleService {
    Article GetArticle(String articleId);
    List<Article> GetArticles(int limit, int page);
    Article SaveArticle(Article article);
    int DeleteArticle(String[] articleIds);
}
