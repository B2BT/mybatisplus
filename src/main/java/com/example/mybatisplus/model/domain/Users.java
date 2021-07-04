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
@ApiModel(value="Users对象", description="")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;
    /** 用户id */
    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid ;

    /** 用户名 */
    @TableField("username")
    private String username ;

    /** 手机号 */
    @TableField("phone")
    private String phone ;

    /** 密码 */
    @TableField("password")
    private String password ;

    @Override
    protected Serializable pkVal() {
        return this.userid;
    }



}