package com.hecy.sourceBorn.mybatis;

import com.hecy.sourceBorn.mybatis.bean.User;
import com.hecy.sourceBorn.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MybatisHelloWorld {
    static SqlSession session = null;

    static {
        String resource = "Configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session = sqlMapper.openSession();
        } catch (IOException e) {
            session.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insert();
    }


    public static void insert() {
        try {
            int temp = 1;
            User user = new User(temp, temp, "userName" + temp, "password" + temp);
            session.insert("com.hecy.sourceBorn.mybatis.mapper.UserMapper.insert", user);
//            session.rollback();
            //一个conn生命周期内，可以存在无数个事务
//            session.commit();
            System.out.println("--------------------");
        } finally {
//            session.close();
        }
    }

    public static User getUser() {
        User user = (User) session.selectOne("com.hecy.sourceBorn.mybatis.mapper.UserMapper.getUser", 3);
        System.out.println(user);
        return user;

    }


}
