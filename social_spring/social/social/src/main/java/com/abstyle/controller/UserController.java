package com.abstyle.controller;

import com.abstyle.pojo.User;
import com.abstyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin //在服务端支持跨域访问
@RestController //如果本类中全部都是ajax请求，则使用此注解，方法上的@ResponseBody可以不写
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/createUser")
    public int createUser(User user){
        return userService.createUser(user);
    }

    @RequestMapping("/login")
    public int login(String name, String password){
        return userService.login(name, password);
    }

    @RequestMapping("/selectUser")
    public User selectUser(String name, String password){
        return userService.selectUser(name,password);
    }

    @RequestMapping("/updateUser")
    public int updateUser(User user){
        System.out.println(user);
        return userService.updateUser(user);
    }

    @RequestMapping("/deleteUser")
    public int deleteUser(String name){
        return userService.deleteUser(name);
    }

}
