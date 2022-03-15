package com.test2.getit.controller;



import com.test2.getit.bean.Result;
import com.test2.getit.bean.User;

import com.test2.getit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName: UserController
 * @Description:
 * @Author Chen Gavin
 * @Date 2021/10/13
 * @Version 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "Can you see me?";
    }

    @GetMapping("/surprise")
    public String surprise(){
        return "How surprise it is!!";
    }


    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/regist218")
    public Object regist218(User user){
        return "regist";
    }

    @PostMapping(value = "/regist")
    public Result regist(User user){
        return userService.regist(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Result login(User user){
        return userService.login(user);
    }

}
