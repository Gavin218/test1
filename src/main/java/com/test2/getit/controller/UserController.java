package com.test2.getit.controller;


import com.test2.getit.Repository.UserRepository;
import com.test2.getit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description:
 * @Author Chen Gavin
 * @Date 2021/10/13
 * @Version 1.0
 */

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Can you see me?";
    }

    @GetMapping("/surprise")
    public String surprise(){
        return "How surprise it is!!";
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象：%s 保存成功！ \n", user);
        }
        return user;
    }

}
