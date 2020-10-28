package com.hecy.sourceBorn.mybatis.bean;


import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: hecy
 * @Date: 2018/12/5 11:13
 * @Version 1.0
 */
public class User {


    private Integer id;

    private String user_name;

    private String password;

    private Integer age;

    public User() {
    }

    public User(Integer id, Integer age, String user_name,String password) {
        this.id = id;
        this.age = age;
        this.user_name = user_name;
        this.password= password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
