package org.za.blog.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.za.blog.entity.ArticleTag;
import org.za.blog.entity.examples.ArticleTagExample;

public interface ArticleTagMapper {
    long countByExample(ArticleTagExample example);

    int deleteByExample(ArticleTagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    List<ArticleTag> selectByExample(ArticleTagExample example);

    ArticleTag selectByPrimaryKey(Integer tagId);

    int updateByExampleSelective(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int updateByExample(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);
}