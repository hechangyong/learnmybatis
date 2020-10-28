package com.hecy.mybatis;

import com.hecy.springBoot.mybatis.MybatisApplication;
import com.hecy.springBoot.mybatis.bean.User;
import com.hecy.springBoot.mybatis.service.UserServiceImpl;
import javafx.application.Application;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: hecy
 * @Date: 2019/8/21 15:40
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =  MybatisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemServiceTest {
    @Autowired
    UserServiceImpl userService;

    private List<User> itemList = new ArrayList<>();

    //生成测试List
    @Before
    public void createList() {

        User test1 = new User();
        test1.setUser_name("test1");
        test1.setPassword("111111");
        for (int i = 0; i < 1000; i++) {//测试会修改此数量
            test1.setAge(i);
            itemList.add(test1);
        }
    }

    //批处理

    public void tesInsert() {
        userService.add(itemList);
    }

    //拼接字符串
    @Test
    @Transactional
    public void testInsert1() {
        userService.add1(itemList);
    }

    //循环插入
    @Test
    @Transactional
    public void testInsert2() {
        userService.add2(itemList);
    }
}
