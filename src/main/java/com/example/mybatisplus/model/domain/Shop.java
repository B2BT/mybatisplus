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
public class Shop extends Model<Shop> {
    private static final long serialVersionUID = 1L;

    /** 卖家id */
    @TableId(value = "shopid", type = IdType.AUTO)
    private Integer shopid ;
    /** 卖家用户名 */
    @TableField("shopusername")
    private String shopusername ;
    /** 卖家密码 */
    @TableField("password")
    private String password ;

    @Override
    protected Serializable pkVal() {
        return this.shopid;
    }


}