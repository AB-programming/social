package com.abstyle.service;

import com.abstyle.pojo.User;

public interface UserService {

    int createUser(User user);

    int login(String name, String password);

    User selectUser(String name, String password);

    int updateUser(User user);

    int deleteUser(String name);
}
