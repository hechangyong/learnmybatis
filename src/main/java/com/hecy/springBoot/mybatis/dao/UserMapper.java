package com.hecy.springBoot.mybatis.dao;


import com.hecy.springBoot.mybatis.bean.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: hecy
 * @Date: 2018/11/21 16:28
 * @Version 1.0
 */

public interface UserMapper extends Mapper<User> {

    int insertTest(User record);

    User selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertByBatch(List<User> itemList);
}
