package org.za.blog.controller;

import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.za.blog.consts.ServerResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "account")
public class ArticleController {

    /**
     * 查询一个文章的属性
     * @param articleId
     * @return
     */
    @PostMapping("getArticle")
    public Object getArticle(@NotNull String articleId){

        return ServerResponse.Success();
    }

    /**
     * 分页查询多个文章的属性
     * @param articleId
     * @return 文章列表
     */
    @PostMapping("listArticle")
    public Object listArticle(@NotNull String articleId){

        return ServerResponse.Success();
    }

    /**
     * 新建一个文章
     * @param articleId
     * @return
     */
    @PostMapping("addArticle")
    public Object addArticle(@NotNull String articleId){

        return ServerResponse.Success();
    }

    /**
     * 编辑一个文章内容
     * @param articleId
     * @return
     */
    @PostMapping("editArticle")
    public Object editArticle(@NotNull String articleId){
        return ServerResponse.Success();
    }

    /**
     * 删除一篇文章
     * @param articleId
     * @return
     */
    @PostMapping("deleteArticle")
    public Object deleteArticle(@NotNull String articleId){

        return ServerResponse.Success();
    }
}
