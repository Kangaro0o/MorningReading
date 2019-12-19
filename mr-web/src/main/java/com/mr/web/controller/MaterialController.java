package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.dto.MaterialListResult;
import com.mr.mybatis.model.Material;
import com.mr.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LiuWen
 * @date 2019-12-19 16:52
 */
@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    /**
     * 获取文章列表
     */
    @GetMapping("/articleList")
    @ResponseBody
    public Result<List<MaterialListResult>> articleList() {
        return new Result<>(ResultStatus.SUCCESS, materialService.getAllList());
    }
    
    /**
     * 查询文件详情
     */
    @GetMapping("/articleDetail/{articleId}")
    @ResponseBody
    public Result articleDetail(@PathVariable("articleId") Integer articleId) {
        Material material = materialService.findById(articleId);
        Result<Material> result = new Result<>();
        result.setCode(ResultStatus.SUCCESS.value());
        result.setMessage("查询成功");
        result.setData(material);
        return result;
    }
}
