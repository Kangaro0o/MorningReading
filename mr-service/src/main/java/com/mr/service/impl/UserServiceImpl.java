package com.mr.service.impl;

import com.mr.mybatis.mapper.UserMapper;
import com.mr.mybatis.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuWen
 * @date 2019-12-19 14:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(String uid) {
        return userMapper.getInfo(uid);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user)!=0;
    }
}
