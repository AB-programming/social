package com.abstyle.mapper;

import com.abstyle.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /*
    * url /user/createUser
    * 参数：
    *   name 用户名;
        password 密码;
      成功返回1，否则返回0
    * */
    int createUser(User user);

    /*
    * url /user/login
    * 参数：
    *   name 用户名;
        password 密码;
    * */
    User selectUser(
        @Param("name")
        String name,
        @Param("password")
        String password
    );

    int updateUser(User user);

    int deleteUser(String name);

    User selectUserByName(String name);
}
