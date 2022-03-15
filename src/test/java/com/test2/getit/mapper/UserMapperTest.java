package com.test2.getit.mapper;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Component
class UserMapperTest {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void getAll() {
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT * FROM  user ");
        System.out.println(mapList.get(0));
    }

}