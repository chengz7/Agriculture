package com.farm.entity;

import lombok.*;

import java.util.Date;

/**
 * @Author: Rain
 * @Description: 对应用户表，使用了lombok插件
 * @Date: Created on 2018/10/31 16:43
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //对应数据库id主键
    private Integer id;
    //用户名
    private String username;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //密码
    private String password;

    //注册状态 0：审核中，1：通过
    private Integer status;

    //注册时间
    private Date createTime;
}
