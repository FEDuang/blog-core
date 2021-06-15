package org.za.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.za.blog.consts.Const;

import java.util.Date;
import java.util.List;

//@Getter
//@ToString
//@Setter
@Document(Const.DOCUMENT_ARTICLE)
public class Article {
    @Id
    private String articleId;
    @Field
    private String articleTitle;
    @Field
    private String articlePreview;
    @Field
    private String articlePath;
    @Field
    private String articlePhotoPath;
    @Field
    private List<Integer> articleTags;
    @Field
    private Integer clickCount;
    @Field
    private Date createdTime;
    @Field
    private Date editedTime;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticlePreview() {
        return articlePreview;
    }

    public void setArticlePreview(String articlePreview) {
        this.articlePreview = articlePreview;
    }

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    public String getArticlePhotoPath() {
        return articlePhotoPath;
    }

    public void setArticlePhotoPath(String articlePhotoPath) {
        this.articlePhotoPath = articlePhotoPath;
    }

    public List<Integer> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(List<Integer> articleTags) {
        this.articleTags = articleTags;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(Date editedTime) {
        this.editedTime = editedTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articlePreview='" + articlePreview + '\'' +
                ", articlePath='" + articlePath + '\'' +
                ", articlePhotoPath='" + articlePhotoPath + '\'' +
                ", articleTags=" + articleTags +
                ", clickCount=" + clickCount +
                ", createdTime=" + createdTime +
                ", editedTime=" + editedTime +
                '}';
    }
}
