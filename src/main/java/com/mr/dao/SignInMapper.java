package com.mr.dao;

import com.mr.model.SignIn;

public interface SignInMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(SignIn record);

    int insertSelective(SignIn record);

    SignIn selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(SignIn record);

    int updateByPrimaryKey(SignIn record);
}