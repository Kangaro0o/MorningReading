package com.mr.mybatis.dto;

import java.util.List;

/**
 * @author lql
 * @date 2019/12/20 11:36
 */
public class ActivityResult {
    private String fileName;
    private List<String> signList;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getSignList() {
        return signList;
    }

    public void setSignList(List<String> signList) {
        this.signList = signList;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "fileName='" + fileName + '\'' +
                ", signList=" + signList +
                '}';
    }
}
