package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.model.SignIn;
import com.mr.service.PasswordService;
import com.mr.service.SignInService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 用户是否在某天已经签到
     */
    @PostMapping(value = "/isSignIn")
    @ResponseBody
    public Result<Boolean> isSign(@RequestParam("uid") String uid, @RequestParam("date") String date) {
        return new Result<>(ResultStatus.SUCCESS, signInService.isSign(uid, date));
    }

    /**
     * 签到
     */
    @PostMapping(value = "/signIn/uid/{uid}")
    @ResponseBody
    public Result<Boolean> signIn(@PathVariable("uid") String uid) {
        Result<Boolean> result = new Result<>();
        // 判断是否已经签到
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date(System.currentTimeMillis()));
        // 组装SignIn对象
        SignIn signIn = new SignIn();
        signIn.setUid(uid);
        signIn.setTime(today);
        // 当天日期存在签到记录时，禁止签到
        if (signInService.isSign(uid, today)) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("你已签到！");
            return result;
        }
        if (signInService.signIn(signIn)) {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("签到成功");
        } else {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("签到失败，请稍后重试");
        }
        return result;
    }

    /**
     * 获取某个用户的所有签到列表
     */
    @ResponseBody
    @GetMapping(value = "/getSignList/id/{id}")
    public Result<List<String>> getList(@PathVariable("id") String id) {
        List<String> res = signInService.getList(id);
        return new Result<>(ResultStatus.SUCCESS, res);
    }
}
