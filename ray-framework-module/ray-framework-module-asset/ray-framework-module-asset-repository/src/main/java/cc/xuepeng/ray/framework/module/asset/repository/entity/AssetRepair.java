package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetRepairStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 资产维修的实体类
 * 数据库表：asset_repairs，资产维修表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetRepair extends BizEntity {

    /**
     * 借用编号
     * 数据库字段：code，har(32)
     */
    private String code;

    /**
     * 设备编号
     * 数据库字段：asset_code，char(32)
     */
    private String assetCode;

    /**
     * 报修时间
     * 数据库字段：start_date，date
     */
    private LocalDate startDate;

    /**
     * 维修公司
     * 数据库字段：company，varchar(128)
     */
    private String company;

    /**
     * 维修费用
     * 数据库字段：cost，decimal(10,2)
     */
    private BigDecimal cost;

    /**
     * 问题描述
     * 数据库字段：reason，varchar(512)
     */
    private String reason;

    /**
     * 状态：0=待维修；1=维修中；2=已完成
     * 数据库字段：status，tinyint
     */
    private AssetRepairStatus status;

    /**
     * 维修结果
     * 数据库字段：result，varchar(512)
     */
    private String result;

    /**
     * 完成时间
     * 数据库字段：end_date，date
     */
    private LocalDate endDate;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}