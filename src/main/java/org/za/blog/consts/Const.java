package org.za.blog.consts;

/**
 * 全局静态常量类
 */
public class Const {

    //    ------------------------ shiro begin ------------------------
    public static final String ALGORITHM_NAME = "sha-256"; // shiro密码加密算法
    public static final int HashIterations = 2; // shiro进行密码加密的次数
    public static final String SALT = "za102nb"; // 盐
    public static final String KEYSTRING = "知行102";
    //    ------------------------  shiro end  ------------------------

    //    ------------------------ entity begin ------------------------
    public static final String DOCUMENT_ARTICLE = "article"; // MongoDB表名
    public static final String ARTICLE_FILENAME = "/article.md"; // md文件名
    public static final String ARTICLE_FILEPATH = "./article/"; // md文件路径
    //    ------------------------  entity end  ------------------------


}
