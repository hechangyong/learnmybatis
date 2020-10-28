package com.hecy.springBoot.mybatis.web;

import com.hecy.springBoot.mybatis.bean.User;
import com.hecy.springBoot.mybatis.service.UserService;
import com.hecy.springBoot.mybatis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hecy
 * @Date: 2018/11/21 14:09
 * @Version 1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class BootController {

    private List<User> itemList = new ArrayList<>();
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setUser_name("test");
        return user;
    }


    @GetMapping("/showUser")
     public User toIndex(HttpServletRequest request) {
         User user = userService.getUserById(1);
        return user;
    }

    @GetMapping("/addUser")
     public User addUser(HttpServletRequest request, Model model) {
        User user = new User();
        user.setUser_name("hecy");
//        user.setAge(123);
        user.setPassword("asd");
        this.userService.addUser(user);
        return user;
    }


    public void createList() {
        itemList.clear();

        for (int i = 0; i < 1000; i++) {//测试会修改此数量
            User test1 = new User();
            test1.setUser_name("test1");
            test1.setPassword("111111");
            test1.setAge(i);
            test1.setId(i+1);
            itemList.add(test1);
        }
    }

    //批处理
    @GetMapping("/ti")
    public void tesInsert() {
        System.out.println("bucht插入开始");
        createList();
        Long s = System.currentTimeMillis();
        userService.add(itemList);
        Long e = System.currentTimeMillis();
        System.out.println("插入结束: " + (e - s) );
    }

    //拼接字符串

    @Transactional
    @GetMapping("/t1")
    public void testInsert1() {

        System.out.println("/t1 插入开始");
        createList();
        Long s = System.currentTimeMillis();
        userService.add1(itemList);
        Long e = System.currentTimeMillis();
        System.out.println("/t1 插入结束" + (e - s));
    }

    //循环插入

    @Transactional
    @GetMapping("/t2")
    public void testInsert2() {
        System.out.println("/t2 插入开始");
        createList();
        Long s = System.currentTimeMillis();
        userService.add2(itemList);
        Long e = System.currentTimeMillis();
        System.out.println("/t2 插入结束" + (e - s) );
    }
}
