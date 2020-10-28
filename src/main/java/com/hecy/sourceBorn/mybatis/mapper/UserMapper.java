package com.hecy.sourceBorn.mybatis.mapper;

import com.hecy.sourceBorn.mybatis.bean.User;

import java.util.List;

/**
 * @Author: hecy
 * @Date: 2018/12/5 11:25
 * @Version 1.0
 */
public interface UserMapper {
    public User getUser(int id);

    //查询所有Employee
    List<User> selectAllUser();
    
    //根据id删除Employee
    void deleteUserById(Integer id);


    void insert(User user);
}
