package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.mybatis.model.SignIn;
import com.mr.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author LiuWen
 * @date 2019-12-18 13:05
 */
@Controller
@RequestMapping("/sign")
public class SignInController {
    @Autowired
    private SignInService signInService;

    @GetMapping(value = "/getSignList/id/{id}")
    @ResponseBody
    @CrossOrigin
    public List<String> getList(@PathVariable("id") String id) {
        return signInService.getList(id);
    }
}
