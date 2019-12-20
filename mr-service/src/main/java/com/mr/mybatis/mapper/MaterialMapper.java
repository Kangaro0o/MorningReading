package com.mr.mybatis.mapper;

import com.mr.mybatis.dto.MaterialListResult;
import com.mr.mybatis.model.Material;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer mid);

    int upload(Material material);

    int insertSelective(Material record);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    /**
     * 获取所有晨读材料
     */
    List<MaterialListResult> getAll();
    
    /**
     * 根据id查询晨读材料详情
     */
    Material findByMid(Integer mid);
}