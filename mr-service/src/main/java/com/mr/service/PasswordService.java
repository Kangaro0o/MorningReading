package com.mr.service;

import com.mr.mybatis.model.Password;

import java.util.Date;

/**
 * @author LiuWen
 * @date 2019-12-18 21:01
 */
public interface PasswordService {
    /**
     * 密码是否匹配
     */
    boolean validate(String password, String today);

    /**
     * 生成签到密钥
     */
    boolean genKey(Password password);

    /**
     * 密码是否已经生成
     */
    String isGen(String date);
}
