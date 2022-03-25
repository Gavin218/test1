package com.test2.getit.service;

import com.test2.getit.bean.Result;
import com.test2.getit.bean.User;
import com.test2.getit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserService
 * @Description:
 * @Author Chen Gavin
 * @Date 2022/3/13
 * @Version 1.0
 */

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            int nameLength = user.getUsername().length();
            int passwordLength = user.getPassword().length();
            if (nameLength == 0 || passwordLength == 0) {
                result.setMsg("用户名或密码不能为空");
            }
            else if (nameLength > 16) {
                result.setMsg("用户名不能超过16个字符！");
            }
            else if (passwordLength > 16 || passwordLength < 6) {
                result.setMsg("密码需要在6——16个字符之间！");
            }
            else {
                User existUser = userMapper.findUserByName(user.getUsername());
                if(existUser != null){
                    //如果用户名已存在
                    result.setMsg("用户名已存在");

                }
                else {
                    userMapper.regist(user);
                    //System.out.println(user.getId());
                    result.setMsg("注册成功");
                    result.setSuccess(true);
                    result.setDetail(user);
                }
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId= userMapper.login(user);
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
