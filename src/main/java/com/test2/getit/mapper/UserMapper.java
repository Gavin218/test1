package com.test2.getit.mapper;

import com.test2.getit.vo.UserVO;

import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {

    @Select("SELECT * FROM user")
    List<UserVO> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    UserVO getOne(int id);


}
