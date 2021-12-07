package com.test2.getit.vo;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
public class UserVO {

    int id;

    String name;

}
