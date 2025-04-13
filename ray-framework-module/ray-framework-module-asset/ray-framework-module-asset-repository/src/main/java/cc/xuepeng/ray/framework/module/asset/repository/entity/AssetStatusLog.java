// AssetStateLog实体类
package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import lombok.*;

/**
 * 资产状态变更记录的实体类
 * 数据库表：asset_status_log，资产状态变更记录表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetStatusLog extends BaseEntity {

    /**
     * 资产编号
     * 数据库字段：asset_code，char(32)
     */
    private String assetCode;

    /**
     * 原状态：0=在库；1=使用；2=维修；3=报废
     * 数据库字段：status_from，tinyint(1)
     */
    private AssetStatus statusFrom;

    /**
     * 新状态：0=在库；1=使用；2=维修；3=报废
     * 数据库字段：status_to，tinyint(1)
     */
    private AssetStatus statusTo;

    /**
     * 是否删除
     * 数据库字段：deleted，tinyint(1)
     */
    private Boolean deleted;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

    /**
     * 创建人
     * 数据库字段：create_user，char(32)
     */
    private String createUser;

    /**
     * 创建时间
     * 数据库字段：create_time，timestamp
     */
    private java.time.LocalDateTime createTime;

}