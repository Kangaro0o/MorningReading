package com.mr.service;

import com.mr.mybatis.dto.SingleSignInResult;
import com.mr.mybatis.model.SignIn;


/**
 * @author LiuWen
 * @date 2019-12-18 13:01
 */
public interface SignInService {
    /**
     * 签到
     */
    boolean signIn(SignIn signIn);

    /**
     * 用户是否已经签到
     */
    boolean isSign(String uid, String time);

    /**
     * 获取用户uid的所有签到记录
     */
    SingleSignInResult getList(String uid);
}
