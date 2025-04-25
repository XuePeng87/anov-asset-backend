package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import lombok.*;

/**
 * 资产信息的实体类
 * 数据库表：asset_info，资产信息表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetInfo extends BizEntity {

    /**
     * 资产分类
     * 数据库字段：category_code，char(32)
     */
    private String categoryCode;

    /**
     * 使用人编号
     * 数据库字段：user_code, varchar(32)
     */
    private String userCode;

    /**
     * 编号
     * 数据库字段：code，char(32)
     */
    private String code;

    /**
     * 名称
     * 数据库字段：name，varchar(100)
     */
    private String name;

    /**
     * 品牌
     * 数据库字段：brand，varchar(100)
     */
    private String brand;

    /**
     * 型号
     * 数据库字段：model，varchar(100)
     */
    private String model;

    /**
     * 规格
     * 数据库字段：specification，varchar(512)
     */
    private String specification;

    /**
     * 状态：0=在库；1=使用；2=维修；3=报废
     * 数据库字段：status，tinyint(1)
     */
    private AssetStatus status;

    /**
     * 存放位置
     * 数据库字段：location，varchar(100)
     */
    private String location;

    /**
     * 采购年份
     * 数据库字段：purchase_year，varchar(10)
     */
    private String purchaseYear;

    /**
     * 设备金额
     * 数据库字段：price，decimal(10,2)
     */
    private java.math.BigDecimal price;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}