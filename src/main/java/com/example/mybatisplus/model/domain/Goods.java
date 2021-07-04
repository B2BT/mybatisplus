package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="卖家对象", description="")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;
    /** 商品id */
    @TableId(value = "goodsid", type = IdType.AUTO)
    private Integer goodsid ;
    /** 商品名 */
    @TableField("goodsname")
    private String goodsname ;
    /** 商品信息 */
    @TableField("info")
    private String info ;
    /** 商品价格 */
    @TableField("price")
    private Double price ;
    /** 商品所属卖家id */
    @TableField("shopid")
    private Integer shopid ;
    /** 商品图片链接 */
    @TableField("goodspic")
    private String goodspic ;

    @Override
    protected Serializable pkVal() {
        return this.goodsid;
    }


}