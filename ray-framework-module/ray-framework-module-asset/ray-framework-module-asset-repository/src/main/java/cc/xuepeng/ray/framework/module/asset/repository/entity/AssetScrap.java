package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetScrapStatus;
import lombok.*;

/**
 * 资产报废的实体类
 * 数据库表：asset_scraps，资产报废表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetScrap extends BizEntity {

    /**
     * 设备编号
     * 数据库字段：asset_code，char(32)
     */
    private String assetCode;

    /**
     * 报废原因
     * 数据库字段：reason，varchar(512)
     */
    private String reason;

    /**
     * 状态：0=通过；1=驳回
     * 数据库字段：status，tinyint
     */
    private AssetScrapStatus status;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}