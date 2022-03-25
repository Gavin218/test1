package com.test2.getit.controller;

import com.test2.getit.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UIController
 * @Description: 前端控制接口
 * @Author Chen Gavin
 * @Date 2022/3/17
 * @Version 1.0
 */

@Controller
@RequestMapping
public class UIController {

    @RequestMapping(value = "/regist")
    public String regist(User user) {
        return "regist";
    }

    @RequestMapping(value = "/login")
    public String login(User user){
        return "login";
    }
}
