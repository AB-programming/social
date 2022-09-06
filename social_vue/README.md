# 接口文档说明

## 1、用户表

**1、数据库设计**

账号name varchar

密码password varchar

用户名use_name varchar

年龄age varchar

性别sex varchar

职业occupation varchar

个性签名signature varchar

**2、接口文档**

url  /user/createUser

参数

```
name;
password;
```

结果 增加成功时：
1
增加失败时:
0



url /user/login

参数

name

passeord

## 2、话题表

- 话题id topic_id
- 话题发起者账号：topic_name
- 话题发起者昵称：topic_user_name
- 话题分类 topic_type
- 话题发布时间：topic_time
- 话题内容：topic_content



## 3、点赞表

- 点赞id：favorite_id
- 点赞者账号：favorite_name
- 被点赞者账号：favorite_target

## 4、评论表

评论id comment_id

帖子id comment_target

评论者账号 comment_name

评论内容 comment_content

评论时间 comment_time