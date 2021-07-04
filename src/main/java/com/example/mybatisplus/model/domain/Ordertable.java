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
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="订单对象", description="")
public class Ordertable extends Model<Ordertable> {
    private static final long serialVersionUID = 1L;
    /** 订单编号 */
    @TableId(value = "orderid", type = IdType.AUTO)
    private Integer orderid;
    /** 创建日期 */
    @TableField("ordertime")
    private Date ordertime ;
    /** 用户id */
    @TableField("userid")
    private Integer userid ;
    /** 商品id */
    @TableField("goodsid")
    private Integer goodsid ;
    /** 是否下单 */
    @TableField("ispay")
    private Integer ispay ;

    @Override
    protected Serializable pkVal() {
        return this.goodsid;
    }


}