package com.mr.service;

import com.mr.mybatis.model.User;

/**
 * @author LiuWen
 * @date 2019-12-19 14:26
 */
public interface UserService {
    /**
     * 根据用户id获取用户信息
     */
    User getUser(String uid);

    /***
     *用户注册，表中添加该用户信息
     */
    boolean addUser(User user);
}
