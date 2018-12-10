package com.hecy.springBoot.mybatis.dao;


import com.hecy.springBoot.mybatis.bean.User;

/**
 * @Author: hecy
 * @Date: 2018/11/21 16:28
 * @Version 1.0
 */
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
