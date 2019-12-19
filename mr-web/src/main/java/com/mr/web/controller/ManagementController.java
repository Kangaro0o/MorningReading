package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.model.Material;
import com.mr.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lql
 * @date 2019/12/19 16:39
 */
@Controller
@RequestMapping("/manage")
@CrossOrigin
public class ManagementController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> upload(@RequestParam("file") MultipartFile file,
                                  @RequestParam("mid")Integer mid, HttpServletRequest request) {

        //获取文件存储位置
        String path=request.getSession().getServletContext().getRealPath("materials");
//        System.out.println(path);
        //加上唯一前缀
        String originalFileName=file.getOriginalFilename();
        String filename=UUID.randomUUID().toString()+originalFileName;
        File newFile=new File(path,filename);
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        Result<String> result;

        try {
            //转存文件
            file.transferTo(newFile);
            //数据库操作
            Material material=new Material();
            material.setName(originalFileName.substring(0,originalFileName.indexOf(".")));
            material.setMid(mid);
            material.setFilePath(path+"\\"+filename);
            if(materialService.uploadMaterial(material)){
                result=new Result<>(ResultStatus.SUCCESS,"上传成功");
            }else {
                result=new Result<>(ResultStatus.ERROR,"数据写入失败");
                //数据写入失败，删除刚刚上传的文件
                File f=new File(path);
                File[] lists=f.listFiles();
                for(File file1 :lists){
                    if(file1.getName().equals(filename)){
                        file1.delete();
                    }
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result=new Result<>(ResultStatus.ERROR,"IOException");
            newFile.delete();
            return result;
        }


    }

    /***
     * 创建活动，晨读表中值写入日期和创建者信息
     * @param date
     * @param uid
     * @return
     */
    @RequestMapping(value = "/createActivity",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> createActivity(@RequestParam("date") String date,
                                         @RequestParam("uid") String uid){
        Material material=new Material();
        material.setUploadTime(date);
        material.setUid(uid);
        Result<String> result;
        if(materialService.createActivity(material)){
            result =new Result<>(ResultStatus.SUCCESS,"创建成功！");
        }else{
            result=new Result<>(ResultStatus.ERROR,"创建失败");
        }
        return result;
    }



}
