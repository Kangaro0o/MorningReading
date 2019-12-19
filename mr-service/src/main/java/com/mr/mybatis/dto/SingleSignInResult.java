package com.mr.mybatis.dto;

import java.util.List;

/**
 * @author LiuWen
 * @date 2019-12-19 17:02
 */
public class SingleSignInResult {
    Integer count;
    List<String> checkdatearr;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getCheckdatearr() {
        return checkdatearr;
    }

    public void setCheckdatearr(List<String> checkdatearr) {
        this.checkdatearr = checkdatearr;
    }
}
