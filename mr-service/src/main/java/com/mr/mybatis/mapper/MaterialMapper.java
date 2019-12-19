package com.mr.mybatis.mapper;

import com.mr.mybatis.model.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer mid);

    int upload(Material material);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}