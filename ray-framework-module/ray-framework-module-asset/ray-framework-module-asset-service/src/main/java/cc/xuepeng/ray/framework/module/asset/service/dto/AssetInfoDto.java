package cc.xuepeng.ray.framework.module.asset.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import lombok.*;

/**
 * 资产信息的数据传输对象
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetInfoDto extends BaseDto {

    /**
     * 资产分类
     */
    private String categoryCode;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 型号
     */
    private String model;

    /**
     * 规格
     */
    private String specification;

    /**
     * 状态：0=在库；1=使用；2=维修；3=报废
     */
    private AssetStatus status;

    /**
     * 存放位置
     */
    private String location;

    /**
     * 采购年份
     */
    private String purchaseYear;

    /**
     * 设备金额
     */
    private java.math.BigDecimal price;

    /**
     * 备注
     */
    private String remark;

}