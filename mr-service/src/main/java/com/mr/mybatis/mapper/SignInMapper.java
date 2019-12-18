package com.mr.mybatis.mapper;

import com.mr.mybatis.model.SignIn;

public interface SignInMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(SignIn record);

    int insertSelective(SignIn record);

    SignIn selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(SignIn record);

    int updateByPrimaryKey(SignIn record);
}