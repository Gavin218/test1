package com.test2.getit.controller;

import com.test2.getit.bean.Result;
import com.test2.getit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AdminController
 * @Description: 管理员操作
 * @Author Chen Gavin
 * @Date 2022/3/17
 * @Version 1.0
 */

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查找某个用户是否存在
     * @param checkName 参数封装
     * @return Result
     */
    @PostMapping(value = "/check")
    public Result check(String checkName) {
        return adminService.check(checkName);
    }



}
