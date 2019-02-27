package cn.wh3t.entity;

import java.util.Date;

/**
 * @program: Wh3tsNews
 * @author: CNWh3t
 * @create: 2019-01-10 16:33
 * @description: 实体类
 * 对应数据库字段：id,username,userpassword,gender,createtime,image
 */

public class User {

    private int id;
    private String userName;
    private String userPassword;
    private int gender; //1男2女
    private Date createTime;
    private String image;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", image='" + image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
