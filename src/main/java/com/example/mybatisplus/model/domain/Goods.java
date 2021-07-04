package com.example.mybatisplus.model.domain;

import java.io.Serializable;

public class Goods implements Serializable,Cloneable{
    /** 商品id */

    private Integer goodsid ;
    /** 商品名 */
    private String goodsname ;
    /** 商品信息 */
    private String info ;
    /** 商品价格 */
    private Double price ;
    /** 商品所属卖家id */
    private Integer shopid ;

    /** 商品id */
    public Integer getGoodsid(){
        return this.goodsid;
    }
    /** 商品id */
    public void setGoodsid(Integer goodsid){
        this.goodsid = goodsid;
    }
    /** 商品名 */
    public String getGoodsname(){
        return this.goodsname;
    }
    /** 商品名 */
    public void setGoodsname(String goodsname){
        this.goodsname = goodsname;
    }
    /** 商品信息 */
    public String getInfo(){
        return this.info;
    }
    /** 商品信息 */
    public void setInfo(String info){
        this.info = info;
    }
    /** 商品价格 */
    public Double getPrice(){
        return this.price;
    }
    /** 商品价格 */
    public void setPrice(Double price){
        this.price = price;
    }
    /** 商品所属卖家id */
    public Integer getShopid(){
        return this.shopid;
    }
    /** 商品所属卖家id */
    public void setShopid(Integer shopid){
        this.shopid = shopid;
    }
}