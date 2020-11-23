package com.tangtang.mybatisaction.model;

import java.util.Date;

public class SysUser {


        private Long id;

        /**
         * 用户名
         */
        private String userName;

        /**
         * 密码
         */
        private String userPassword;

        /**
         * 邮箱
         */
        private String userEmail;

        /**
         * 简介
         */
        private String userInfo;

        /**
         * 头像
         */
        private byte[] headImg;

        /**
         * 创建时间
         */
        private Date createTime;

        // 按Alt+Insert快捷键生成get和set方法


    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
