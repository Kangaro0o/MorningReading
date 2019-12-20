package com.mr.mybatis.mapper;

import com.mr.mybatis.dto.SingleSignInResult;
import com.mr.mybatis.model.SignIn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignInMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(SignIn record);

    int insertSelective(SignIn record);

    SignIn selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(SignIn record);

    int updateByPrimaryKey(SignIn record);

    int select(SignIn signIn);

    /**
     * 查找id对应的用户的签到记录
     */
    SingleSignInResult getList(String uid);

    /***
     * 找到某天签到的用户名
     */
    List<String> findUidByDate(String date);
}