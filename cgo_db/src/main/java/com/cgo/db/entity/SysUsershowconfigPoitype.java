package com.cgo.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2019-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_UserShowConfig_PoiType")
public class SysUsershowconfigPoitype extends Model<SysUsershowconfigPoitype> {

    private static final long serialVersionUID=1L;

    @TableId("PoiType")
    private Integer PoiType;

    @TableField("UserId")
    private String UserId;


    @Override
    protected Serializable pkVal() {
        return this.PoiType;
    }

}
