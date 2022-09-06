package com.abstyle.pojo;

public class User {
    private String name;
    private String password;
    private String userName;
    private String age;
    private String sex;
    private String occupation;
    private String signature;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", occupation='" + occupation + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public User(String name, String password, String userName, String age, String sex, String occupation, String signature) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.occupation = occupation;
        this.signature = signature;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
