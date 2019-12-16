package com.mr.dao;

import com.mr.model.Password;

public interface PasswordMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);
}