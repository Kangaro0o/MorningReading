package com.mr.service.impl;

import com.mr.mybatis.dto.MaterialListResult;
import com.mr.mybatis.mapper.MaterialMapper;
import com.mr.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuWen
 * @date 2019-12-19 20:58
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public List<MaterialListResult> getAllList() {
        return materialMapper.getAll();
    }
}
