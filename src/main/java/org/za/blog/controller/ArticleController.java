package org.za.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.blog.consts.ServerResponse;
import org.za.blog.dto.ListArticleParam;
import org.za.blog.dto.SaveArticleParam;
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
    public Object getArticle(@RequestBody String articleId) {
        return ServerResponse.Success(articleService.GetArticle(articleId));
    }

    /**
     * 分页查询多个文章的属性
     *
     * @param listArticleParam
     * @return 文章列表
     */
    @PostMapping("listArticle")
    public Object listArticle(@RequestBody ListArticleParam listArticleParam) {
        return ServerResponse.Success(articleService.GetArticles(listArticleParam.getPageSize(), listArticleParam.getPageNum()));
    }

//    /**
//     * 查询一个文章的内容(md文件)
//     *
//     * @param articleId
//     * @return
//     */
//    @PostMapping("getArticleDetail")
//    public Object getArticleDetail(String articleId) {
//        return ServerResponse.Success(articleService.GetArticle(articleId));
//    }

    /**
     * 新建一个文章
     *
     * @param saveArticleParam
     * @return
     */
    @PostMapping("addArticle")
    public Object addArticle(@RequestBody SaveArticleParam saveArticleParam) {
        Article article = new Article();
        article.setArticleTitle(saveArticleParam.getArticleTitle());
        article.setArticlePreview(saveArticleParam.getArticlePreview());

        String path = articleService.SaveArticle(article, saveArticleParam.getContext());
        if (path.length() > 0)
            return ServerResponse.Success(path);
        return ServerResponse.Error();
    }

    /**
     * 编辑一个文章
     *
     * @param saveArticleParam
     * @return
     */
    @PostMapping("editArticle")
    public Object editArticle(@RequestBody SaveArticleParam saveArticleParam) {
        Article article = articleService.GetArticle(saveArticleParam.getArticleID());
        article.setArticleTitle(saveArticleParam.getArticleTitle());
        article.setArticlePreview(saveArticleParam.getArticlePreview());

        String path = articleService.SaveArticle(article, saveArticleParam.getContext());
        if (path.length() > 0)
            return ServerResponse.Success(path);
        return ServerResponse.Error();
    }

    /**
     * 删除一篇文章
     *
     * @param articleId
     * @return
     */
    @PostMapping("deleteArticle")
    public Object deleteArticle(@RequestBody String articleId) {
        return ServerResponse.Create(articleService.DeleteArticle(articleId));
    }
}
