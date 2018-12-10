package com.hecy.sourceBorn.mybatis;

import com.hecy.sourceBorn.mybatis.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: hecy
 * @Date: 2018/12/5 11:12
 * @Version 1.0
 */
public class MybatisHelloWorld {
    public static void main(String[] args) {
        String resource = "Configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = (User) session.selectOne("com.hecy.sourceBorn.mybatis.mapper.UserMapper.getUser", 1);

                System.out.println(user.getId() + "," + user.getUserName());
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
