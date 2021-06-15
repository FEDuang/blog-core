package org.za.blog.service.impl;

import cn.hutool.core.io.file.FileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;
import org.za.blog.service.IArticleService;

import java.io.File;
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
    public String SaveArticle(Article article, String context) {
        String fileName = "../../../../../../article/" + article.getArticleId() + "/article.md";
        FileWriter fileWriter = new FileWriter(new File(fileName));
        fileWriter.write(context);
        articleDao.save(article);
        return fileName;
    }

    @Override
    public boolean DeleteArticle(String articleIds) {
        String fileName = "../../../../../../article/" + articleIds + "/article.md";
        File file = new File(fileName);
        if (file.delete()){
            articleDao.delete(articleIds);
            return true;
        }
        return false;
    }
}
