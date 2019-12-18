package com.mr.service.impl;

import com.mr.mybatis.mapper.SignInMapper;
import com.mr.mybatis.model.SignIn;
import com.mr.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuWen
 * @date 2019-12-18 13:01
 */
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private SignInMapper signInMapper;

    @Override
    public int signIn(String uid, String pwd) {
        // TODO
        return 0;
    }

    /**
     * 判断用户是否在某天签到
     */
    @Override
    public boolean isSign(String uid, String time) {
        SignIn signIn = new SignIn();
        signIn.setUid(uid);
        try {
            signIn.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return signInMapper.select(signIn) != 0;
    }

    @Override
    public List<String> getList(String uid) {
        List<SignIn> lists =  signInMapper.getList(uid);
        // 修改时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> res = new ArrayList<>();
        for (SignIn signIn : lists) {
            res.add(sdf.format(signIn.getTime()));
        }
        return res;
    }


}
