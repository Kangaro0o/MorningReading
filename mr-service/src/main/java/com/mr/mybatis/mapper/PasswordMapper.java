package com.mr.mybatis.mapper;

import com.mr.mybatis.model.Password;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface PasswordMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);

    Integer findByPwdAndTime(@Param("pwd") String pwd,@Param("today") Date today);
}