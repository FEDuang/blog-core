package org.za.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.za.blog.consts.ServerResponse;
import org.za.blog.entity.Article;
import org.za.blog.service.IArticleService;

@CrossOrigin
@RestController
@RequestMapping(value = "article")
public class ArticleController {
    private final IArticleService articleService;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 查询一个文章的属性
     *
     * @param articleId
     * @return
     */
    @PostMapping("getArticle")
    public Object getArticle(String articleId) {
        return ServerResponse.Success(articleService.GetArticle(articleId));
    }

    /**
     * 分页查询多个文章的属性
     *
     * @param limit 每页数量
     * @param page  页数
     * @return 文章列表
     */
    @PostMapping("listArticle")
    public Object listArticle(int limit, int page) {

        return ServerResponse.Success();
    }

    /**
     * 保存一个文章，包括新建和编辑
     *
     * @param article
     * @param context
     * @return
     */
    @PostMapping("saveArticle")
    public Object saveArticle(Article article, String context) {
        return ServerResponse.Success(articleService.SaveArticle(article, context));
    }

    /**
     * 删除一篇文章
     *
     * @param articleId
     * @return
     */
    @PostMapping("deleteArticle")
    public Object deleteArticle(String articleId) {
        return ServerResponse.create(articleService.DeleteArticle(articleId));
    }
}
