package com.example.mybatisplus.model.domain;

import java.io.Serializable;
import java.util.Date;

//@Table(name="订单表")
public class Order implements Serializable,Cloneable{
    /** 订单编号 */
    private Integer ordertable ;
    /** 创建日期 */
    private Date ordertime ;
    /** 用户id */
    private Integer userid ;
    /** 商品id */
    private Integer goodsid ;
    /** 是否下单 */
    private Integer ispay ;

    /** 订单编号 */
    public Integer getOrdertable(){
        return this.ordertable;
    }
    /** 订单编号 */
    public void setOrdertable(Integer ordertable){
        this.ordertable = ordertable;
    }
    /** 创建日期 */
    public Date getOrdertime(){
        return this.ordertime;
    }
    /** 创建日期 */
    public void setOrdertime(Date ordertime){
        this.ordertime = ordertime;
    }
    /** 用户id */
    public Integer getUserid(){
        return this.userid;
    }
    /** 用户id */
    public void setUserid(Integer userid){
        this.userid = userid;
    }
    /** 商品id */
    public Integer getGoodsid(){
        return this.goodsid;
    }
    /** 商品id */
    public void setGoodsid(Integer goodsid){
        this.goodsid = goodsid;
    }
    /** 是否下单 */
    public Integer getIspay(){
        return this.ispay;
    }
    /** 是否下单 */
    public void setIspay(Integer ispay){
        this.ispay = ispay;
    }
}