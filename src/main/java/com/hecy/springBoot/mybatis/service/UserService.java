package com.hecy.springBoot.mybatis.service;

import com.hecy.springBoot.mybatis.bean.User;

/**
 * @Author: hecy
 * @Date: 2018/11/21 16:45
 * @Version 1.0
 */
public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}
