package com.abstyle.service.impl;

import com.abstyle.mapper.UserMapper;
import com.abstyle.pojo.User;
import com.abstyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //注入进数据访问层的对象
    @Autowired
    UserMapper userMapper;

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public User selectUser(String name, String password) {
        return userMapper.selectUser(name, password);
    }

    @Override
    public int login(String name, String password) {
        User login = userMapper.selectUser(name, password);
        if (login != null && login.getName() != null){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteUser(String name) {
        return userMapper.deleteUser(name);
    }
}
