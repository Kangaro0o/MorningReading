package com.mr.service.impl;


import com.mr.mybatis.bo.ArticleDetail;
import com.mr.mybatis.dto.MaterialListResult;
import com.mr.mybatis.mapper.MaterialMapper;
import com.mr.mybatis.model.Material;

import com.mr.service.MaterialService;
import com.mr.utils.DocUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuWen&lql
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

    @Override
    public Material findById(Integer id) {
        return materialMapper.findById(id);
    }

    @Override
    public ArticleDetail getArticleDetail(Integer articleId) {
        Material material = findById(articleId);
        ArticleDetail articleDetail = new ArticleDetail();
        String content = DocUtil.doc2String(material.getFilePath());
        articleDetail.setTitle(material.getName());
        articleDetail.setContent(content);
        articleDetail.setDate(material.getUploadTime());
        return articleDetail;
    }


    @Override
    public boolean uploadMaterial(Material material) {
        return materialMapper.upload(material)!=0;
    }

    @Override
    public boolean createActivity(Material material) {
        return materialMapper.insertSelective(material)!=0;
    }
}
