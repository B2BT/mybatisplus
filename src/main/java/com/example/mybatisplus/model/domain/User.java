package com.example.mybatisplus.model.domain;

import java.io.Serializable;

public class User implements Serializable,Cloneable{
    /** 用户id */

    private Integer userid ;
    /** 用户名 */
    private String username ;
    /** 手机号 */
    private String phone ;
    /** 密码 */
    private String password ;

    /** 用户id */
    public Integer getUserid(){
        return this.userid;
    }
    /** 用户id */
    public void setUserid(Integer userid){
        this.userid = userid;
    }
    /** 用户名 */
    public String getUsername(){
        return this.username;
    }
    /** 用户名 */
    public void setUsername(String username){
        this.username = username;
    }
    /** 手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 手机号 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 密码 */
    public String getPassword(){
        return this.password;
    }
    /** 密码 */
    public void setPassword(String password){
        this.password = password;
    }
}