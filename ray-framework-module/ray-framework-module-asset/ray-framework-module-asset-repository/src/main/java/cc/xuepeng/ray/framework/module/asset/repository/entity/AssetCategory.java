package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import lombok.*;

/**
 * 资产分类的实体类
 * 数据库表：asset_category，资产类型表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetCategory extends BizEntity {

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
     * 排序
     * 数据库字段：sequence，int(11)
     */
    private Integer sequence;

}