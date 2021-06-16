package org.za.blog.service;

import org.za.blog.entity.Article;
import org.za.blog.utils.PageResult;

import java.util.List;

public interface IArticleService {
    Article GetArticle(String articleId);
    PageResult<Article> GetArticles(int limit, int page);
    String SaveArticle(Article article, String context);

    /**
     * 删除文章
     * @param articleIds
     * @return True 只有同时删除文件和数据库数据，否则，False
     */
    boolean DeleteArticle(String articleIds);
}
