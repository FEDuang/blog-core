package org.za.blog.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.za.blog.consts.Const;
import org.za.blog.dao.mongo.IArticleDao;
import org.za.blog.entity.Article;
import org.za.blog.service.IArticleService;
import org.za.blog.utils.PageResult;

import java.io.File;
import java.util.Date;
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
    public String GetArticleContext(String articleId) {
        String fileName = getFileName(articleId);
        FileReader fileReader = new FileReader(new File(fileName));
        return fileReader.readString();
    }


    @Override
    public PageResult<Article> GetArticles(int limit, int page) {
        return articleDao.findByPage(page, limit);
    }

    @Override
    public String SaveArticle(Article article, String context) {
        if (ObjectUtils.isEmpty(article)) {
            return "";
        }
        if (ObjectUtils.isEmpty(article.getArticleId())){
            article.setArticleId(new ObjectId().toString());
        }
        article.setCreatedTime(new Date());
        article.setEditedTime(new Date());
        article.setClickCount(ObjectUtils.isEmpty(article.getClickCount())?0:article.getClickCount());
        String fileName = getFileName(article.getArticleId());
        try {
            if (!FileUtil.exist(fileName)) {
                FileUtil.touch(fileName);
            }
            FileWriter fileWriter = new FileWriter(new File(fileName));
            fileWriter.write(context);
        } catch (IORuntimeException e) {
            e.printStackTrace();
            //回滚，删除创建的空文件
            if (FileUtil.exist(fileName)) {
                FileUtil.del(fileName);
            }
            return "";
        }
        articleDao.save(article);
        return fileName;
    }

    @Override
    public boolean DeleteArticle(String articleId) {
        String fileName = getFileName(articleId);
        if (FileUtil.exist(fileName)) {
            File file = new File(fileName);
            if (file.delete() && new File(file.getParent()).delete()) {
                articleDao.delete(articleId);
                return true;
            }
        }
        return false;
    }

    private String getFileName(String ObjectId) {
        return Const.ARTICLE_FILEPATH + ObjectId + Const.ARTICLE_FILENAME;
    }
}
