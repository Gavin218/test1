package com.test2.getit.bean;

/**
 * @ClassName: User
 * @Description:
 * @Author Chen Gavin
 * @Date 2022/3/13
 * @Version 1.0
 */


public class User {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
