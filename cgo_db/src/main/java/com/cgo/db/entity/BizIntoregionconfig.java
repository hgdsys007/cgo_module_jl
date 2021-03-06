package com.cgo.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
@TableName("biz_IntoRegionConfig")
public class BizIntoregionconfig extends Model<BizIntoregionconfig> {

    private static final long serialVersionUID=1L;

    @TableField("UpdateTime")
    private LocalDateTime UpdateTime;

    @TableField("OrgId")
    private Integer OrgId;

    @TableField("RegionId")
    private Integer RegionId;

    @TableField("IsDel")
    private Boolean IsDel;

    @TableField("Interval")
    private Integer Interval;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
