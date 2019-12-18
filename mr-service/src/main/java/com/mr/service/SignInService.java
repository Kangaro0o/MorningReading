package com.mr.service;

import com.mr.mybatis.model.SignIn;

import java.util.Date;
import java.util.List;

/**
 * @author LiuWen
 * @date 2019-12-18 13:01
 */
public interface SignInService {
    /**
     * 签到
     * @param uid 用户id
     * @param pwd 签到密码
     */
    int signIn(String uid, String pwd);

    /**
     * 用户是否已经签到
     */
    boolean isSign(String uid, String time);

    /**
     * 获取用户uid的所有签到记录
     */
    List<String> getList(String uid);
}
