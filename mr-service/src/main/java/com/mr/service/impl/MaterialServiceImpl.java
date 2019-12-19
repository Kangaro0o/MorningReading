package com.mr.service.impl;

import com.mr.mybatis.mapper.MaterialMapper;
import com.mr.mybatis.model.Material;
import com.mr.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lql
 * @date 2019/12/19 19:51
 */
@Service
public class MaterialServiceImpl  implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public boolean uploadMaterial(Material material) {
        return materialMapper.upload(material)!=0;
    }

    @Override
    public boolean createActivity(Material material) {
        return materialMapper.insertSelective(material)!=0;
    }
}
