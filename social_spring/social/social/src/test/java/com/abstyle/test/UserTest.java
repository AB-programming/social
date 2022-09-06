package com.abstyle.test;

import com.abstyle.pojo.Favorite;
import com.abstyle.pojo.Topic;
import com.abstyle.pojo.User;
import com.abstyle.service.FavoriteService;
import com.abstyle.service.TopicService;
import com.abstyle.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动spring的容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testCreateUser(){
        User user = new User("1214155","123456","张三","18","男","学生",
                "打篮球");
        int num = userService.createUser(user);
        System.out.println(num);
    }
    @Test
    public void testUpdateUser(){
        User user = new User("11","","李四","33","女","教师",
                "打篮球");
        int num = userService.updateUser(user);
        System.out.println(num);
    }
}
