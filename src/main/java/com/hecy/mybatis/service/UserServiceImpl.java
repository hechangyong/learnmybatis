package com.hecy.mybatis.service;

import com.hecy.mybatis.bean.User;
import com.hecy.mybatis.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: hecy
 * @Date: 2018/11/21 16:46
 * @Version 1.0
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
