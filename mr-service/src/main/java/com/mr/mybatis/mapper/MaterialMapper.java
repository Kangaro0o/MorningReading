package com.mr.mybatis.mapper;

import com.mr.mybatis.dto.MaterialListResult;
import com.mr.mybatis.model.Material;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<MaterialListResult> getAll();
}