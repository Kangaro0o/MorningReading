package com.mr.web.controller;

import com.mr.common.Result;
import com.mr.common.ResultStatus;
import com.mr.mybatis.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.rmi.server.UID;
import java.util.HashMap;
import java.util.Map;


/**
 * @author LiuWen
 * @date 2019-12-19 14:24
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 获取用户信息
     */
    @PostMapping("/getinfo")
    @ResponseBody
    public Result<User> getUserInfo(@RequestParam("uid") String uid) {
        User user = userService.getUser(uid);
        Result<User> result = new Result<>();
        if (user == null) {
            result.setCode(ResultStatus.ERROR.value());
            result.setMessage("没有此用户");
        } else {
            result.setCode(ResultStatus.SUCCESS.value());
            result.setMessage("查询成功");
            result.setData(user);
        }
        return result;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> register(@RequestBody User user){

        User u= userService.getUser(user.getId());
        Result<Boolean> result;
        //判断用户是否已经注册
        if(u==null){
            //判断输入格式是否正确
            if(user.getId()!=null&&user.getName()!=null&&user.getRole()!=null&&(user.getRole()==1||user.getRole()==2)) {
                //用户注册
                if (userService.addUser(user)) {
                    result = new Result<>(ResultStatus.SUCCESS, true);
                } else {
                    result = new Result<>(ResultStatus.DATABASE_WRITE_ERROR, false);
                }
            }else{
                result=new Result<>(ResultStatus.PARAMETER_ILLEGAL,false);
            }
        }else {
            result=new Result<>(ResultStatus.USER_HAS_EXISTED,false);
        }

        return result;
    }

    @GetMapping("/adminvalue/{userid}")
    @ResponseBody
    public Result<Map<String, Integer>> getUserRole(@PathVariable("userid") String uid) {
        Map<String, Integer> map = new HashMap<>(1);
        map.put("admin", userService.getUserRole(uid));
        return new Result<Map<String, Integer>>(ResultStatus.SUCCESS, map);
    }
}
