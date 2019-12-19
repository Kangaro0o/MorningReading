package com.mr.service;

import com.mr.mybatis.model.Material;

/**
 * @author lql
 * @date 2019/12/19 19:50
 */
public interface MaterialService {
    public boolean uploadMaterial(Material material);

    public boolean createActivity(Material material);
}
