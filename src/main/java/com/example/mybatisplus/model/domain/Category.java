package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxp
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Category对象", description="")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    private String cid;

    private String cname;


    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

}
