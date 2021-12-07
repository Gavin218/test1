package com.test2.getit.mapper.impl;

import com.test2.getit.mapper.UserMapper;
import com.test2.getit.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserVO> getAll() {
        return null;
    }

    @Override
    public UserVO getOne(int id) {
        return null;
    }

}
