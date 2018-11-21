package com.hecy.mybatis.web;

import com.hecy.mybatis.bean.User;
import com.hecy.mybatis.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: hecy
 * @Date: 2018/11/21 14:09
 * @Version 1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class BootController {

    @Resource
    private UserService userService;

    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        return user;
    }


    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public User addUser(HttpServletRequest request, Model model){
        User user = new User();
        user.setUserName("hecy");
        user.setAge(123);
        user.setPassword("asd");
        this.userService.addUser(user);
        return user;
    }
}
