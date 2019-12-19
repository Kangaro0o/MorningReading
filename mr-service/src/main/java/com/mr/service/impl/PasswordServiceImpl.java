package com.mr.service.impl;

import com.mr.mybatis.mapper.PasswordMapper;
import com.mr.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author LiuWen
 * @date 2019-12-18 21:01
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    private PasswordMapper passwordMapper;

    @Override
    public boolean validate(String password, String today) {
        try {
            Integer res = passwordMapper.findByPwdAndTime(password, DateFormat.getDateInstance().parse(today));
            return res != null;
        } catch (ParseException e) {
            return false;
        }
    }
}
