package com.mr.service.impl;

import com.mr.adapter.DateTimeAdapter;
import com.mr.mybatis.dto.SingleSignInResult;
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
    public boolean signIn(SignIn signIn) {
        return signInMapper.insert(signIn) != 0;
    }

    /**
     * 判断用户是否在某天签到
     */
    @Override
    public boolean isSign(String uid, String time) {
        SignIn signIn = new SignIn();
        signIn.setUid(uid);
        signIn.setTime(time);
        return signInMapper.select(signIn) != 0;
    }

    @Override
    public SingleSignInResult getList(String uid) {
        SingleSignInResult result =  signInMapper.getList(uid);
        DateTimeAdapter dta = new DateTimeAdapter();
        List<String> checkArr = new ArrayList<>();
        for (String str : result.getCheckdatearr()) {
            checkArr.add(dta.strDateToInt(str) + "");
        }
        result.setCount(result.getCheckdatearr().size());
        result.setCheckdatearr(checkArr);
        return result;
    }

    @Override
    public List<String> findUidByDate(String date) {
        return signInMapper.findUidByDate(date);
    }


}
