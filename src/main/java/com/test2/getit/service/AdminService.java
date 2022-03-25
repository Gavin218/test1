package com.test2.getit.service;

import com.test2.getit.bean.Result;
import com.test2.getit.bean.User;
import com.test2.getit.mapper.AdminMapper;
import com.test2.getit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: AdminService
 * @Description: 管理员功能
 * @Author Chen Gavin
 * @Date 2022/3/17
 * @Version 1.0
 */

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询
     * @param checkName 参数封装
     * @return Result
     */
    public Result check(String checkName) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User user = userMapper.findUserByName(checkName);
            if (null == user) {
                result.setMsg("未查询到该用户信息！");
            }
            else {
                result.setMsg("查询成功！");
                result.setSuccess(true);
                result.setDetail(user);
            }
        }
        catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}
