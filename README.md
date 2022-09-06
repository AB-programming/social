# 社交项目

## 一、项目简介
### 前后端分离项目，本地未打包，前端端口8080，后端端口8082，前端使用@vue/cli3构建，后端服务器为tomcat8，数据库使用MySQL，跨域使用axios

## 二、技术选型
### 前端:Vue2+elementUi+bluma+axios
### 后端:Java+Spring+SpringMVC+Mybatis+MySQL 

## 三、功能介绍
### 1、注册、登录，有校验
### 2、个人信息编辑修改、退出、注销登录
### 3、发布帖子，按时间排序展示，有登录校验
### 4、点赞、评论，显示点赞评论数量，有校验
## 四、启动方式

### 1、前提条件：
​	**jdk8、tomcat8、node环境、vue2、vue脚手架3、MySQL，后端最好是IDE——Intellij IDEA**
### 2、建库建表,执行以下sql语句
```sql
CREATE DATABASE social;
use social;
CREATE TABLE users(
    name varchar(255) primary key ,
    password varchar(255),
    user_name varchar(255),
    age varchar(255),
    sex varchar(255),
    occupation varchar(255),
    signature varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE topic(
    topic_id varchar(255) primary key,
    topic_name varchar(255),
    topic_user_name varchar(255),
    topic_type varchar(255),
    topic_time varchar(255),
    topic_content varchar(255)
)ENGINE =InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE favorite(
    favorite_id varchar(255) primary key ,
    favorite_name varchar(255),
    favorite_target varchar(255)
)ENGINE =InnoDB DEFAULT CHARSET =utf8;

CREATE TABLE comment(
    comment_id varchar(255) primary key,
    comment_target varchar(255),
    comment_name varchar(255),
    comment_user_name varchar(255),
    comment_content varchar(255),
    comment_time varchar(255)
)ENGINE =InnoDB DEFAULT CHARSET =utf8;
```
### 3、后端启动：
​	**我是在IDEA中部署tomcat8，Jre是1.8，端口号是8082，根路径是/，勾选Deploy applications configured in Tomcat instance，当然也可以自己去tomcat8中部署，war包在social_spring/social/social/target下，social-1.0.war**
    **【注意更改social_spring/social/social/src/main/resources/jdbc.properties的数据库管理员和密码】**
### 4、前端启动
​	**有vue和脚手架的环境后，进入social_vue目录，执行npm run serve启动**
### 5、
   **全部启动没有异常后访问http://localhost:8080**


