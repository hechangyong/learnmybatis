package com.hecy.springBoot.mybatis.service;

import com.hecy.springBoot.mybatis.bean.User;
import com.hecy.springBoot.mybatis.dao.UserMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hecy
 * @Date: 2018/11/21 16:46
 * @Version 1.0
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    //批处理
    @Transactional
    public void add(List<User> itemList) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        UserMapper mapper = session.getMapper(UserMapper.class);
        for (int i = 0; i < itemList.size(); i++) {
            mapper.insert(itemList.get(i));
            if (i % 1000 == 999) {//每1000条提交一次防止内存溢出
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
    }

    //拼接sql
    @Transactional
    public void add1(List<User> itemList) {
//        System.out.println(userDao.selectAll());
        itemList.forEach(userDao::insert);
    }

    //循环插入
    @Transactional
    public void add2(List<User> itemList) {
        itemList.forEach(userDao::insert);
    }


    /**
     * @param userId
     * @return
     */
    public User getUserById(int userId) {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.SIMPLE, true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record) {
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
