package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.model.Password;
import com.mr.mybatis.model.User;
import com.mr.service.PasswordService;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuWen
 * @date 2019-12-19 13:32
 */
@Controller
@RequestMapping("/pwd")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UserService userService;
    /**
     * 管理员生成签到密码
     */
    @PostMapping("/genKey")
    @ResponseBody
    public Result genKey(Password password) {
        Result<String> result = new Result<>();
        // 查看其身份是否是管理员
        User user = userService.getUser(password.getUid());
        if (user == null || user.getRole() < 2) {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("您的权限不够！");
            return result;
        }
        // 查看密码是否已经被生成
        String pwd = (passwordService.isGen(password.getTime()));
        if (pwd != null) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("密码已被生成");
            result.setData(pwd);
            return result;
        }
        if (passwordService.genKey(password)) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("密码生成成功");
            result.setData(password.getPwd());
        } else {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("密码生成失败，请稍后重试");
            result.setData(null);
        }
        return result;
    }

    /**
     * 匹配打卡密码是否匹配
     */
    @ResponseBody
    @PostMapping("/validatePwd")
    public Result validatePwd(@RequestParam("password") String password) {
        Result result = new Result();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date(System.currentTimeMillis());
        System.out.println("password: " + password + ", today: " + sdf.format(today));
        if (passwordService.validate(password, sdf.format(today))) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("密码验证成功");
        } else {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("密码验证失败");
        }
        return result;
    }
}
