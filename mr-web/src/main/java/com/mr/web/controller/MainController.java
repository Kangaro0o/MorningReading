package com.mr.web.controller;


import com.mr.common.Result;
import com.mr.mybatis.mapper.SignInMapper;
import com.mr.mybatis.model.SignIn;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/test")
public class MainController {
    @Autowired
    SignInMapper signInMapper;

    @GetMapping(value = "/sign-insert")
    @CrossOrigin
    @ResponseBody
    public int testInsert() throws ParseException {
        SignIn signIn = new SignIn();
        signIn.setUid("abc");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = sdf.parse("2019-10-01");
        signIn.setTime(dateTime);
        return signInMapper.insert(signIn);
    }

}
