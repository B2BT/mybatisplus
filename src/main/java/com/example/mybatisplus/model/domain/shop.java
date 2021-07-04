package com.example.mybatisplus.model.domain;


import java.io.Serializable;
import java.util.Date;


//@Table(name="卖家表")
public class shop implements Serializable,Cloneable{
    /** 卖家id */
    private Integer shopid ;
    /** 卖家用户名 */
    private String shopusername ;
    /** 卖家密码 */
    private String createdTime ;

    /** 卖家id */
    public Integer getShopid(){
        return this.shopid;
    }
    /** 卖家id */
    public void setShopid(Integer shopid){
        this.shopid = shopid;
    }
    /** 卖家用户名 */
    public String getShopusername(){
        return this.shopusername;
    }
    /** 卖家用户名 */
    public void setShopusername(String shopusername){
        this.shopusername = shopusername;
    }
    /** 卖家密码 */
    public String getCreatedTime(){
        return this.createdTime;
    }
    /** 卖家密码 */
    public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
    }
}