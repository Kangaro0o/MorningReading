package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.model.SignIn;
import com.mr.service.PasswordService;
import com.mr.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author LiuWen
 * @date 2019-12-18 13:05
 */
@Controller
@RequestMapping("/sign")
@CrossOrigin
public class SignInController {
    @Autowired
    private SignInService signInService;

    @Autowired
    private PasswordService passwordService;


    /**
     * 获取某个用户的所有签到列表
     */
    @ResponseBody
    @GetMapping(value = "/getSignList/id/{id}")
    public Result<List<String>> getList(@PathVariable("id") String id) {
        List<String> res =  signInService.getList(id);
        return new Result<>(ResultStatus.SUCCESS, res);
    }

    /**
     * 匹配打卡密码是否匹配
     */
    @ResponseBody
    @PostMapping("/validatePwd")
    public Result validatePwd(@RequestParam(value = "password") String password) {
        Result result = new Result();
        if (passwordService.validate(password, "2019-10-01")) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("密码验证成功");
        } else {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("密码验证失败");
        }
        return result;
    }
}
