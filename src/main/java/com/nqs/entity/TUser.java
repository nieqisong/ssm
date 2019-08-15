package com.nqs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
public class TUser {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("loginacct")
    private String loginacct;

    @TableField("userpswd")
    private String userpswd;

    @TableField("username")
    private String username;

    @TableField("email")
    private String email;

    @TableField("createtime")
    private String createtime;

    public TUser() {
    }

    public TUser(Integer id, String loginacct, String userpswd, String username, String email, String createtime) {
        this.id = id;
        this.loginacct = loginacct;
        this.userpswd = userpswd;
        this.username = username;
        this.email = email;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "loginacct='" + loginacct + '\'' +
                ", userpswd='" + userpswd + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }

    public String getUserpwd() {
        return userpswd;
    }

    public void setUserpwd(String userpswd) {
        this.userpswd = userpswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreattime() {
        return createtime;
    }

    public void setCreattime(String createtime) {
        this.createtime = createtime;
    }
}
