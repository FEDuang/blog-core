package com.za.blogcore.dao;

import com.za.blogcore.entity.URTable;
import com.za.blogcore.entity.examples.URTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface URTableMapper {
    long countByExample(URTableExample example);

    int deleteByExample(URTableExample example);

    int deleteByPrimaryKey(Integer urid);

    int insert(URTable record);

    int insertSelective(URTable record);

    List<URTable> selectByExample(URTableExample example);

    URTable selectByPrimaryKey(Integer urid);

    int updateByExampleSelective(@Param("record") URTable record, @Param("example") URTableExample example);

    int updateByExample(@Param("record") URTable record, @Param("example") URTableExample example);

    int updateByPrimaryKeySelective(URTable record);

    int updateByPrimaryKey(URTable record);
}