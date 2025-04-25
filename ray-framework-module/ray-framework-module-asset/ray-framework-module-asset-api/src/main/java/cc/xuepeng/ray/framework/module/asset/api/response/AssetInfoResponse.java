package cc.xuepeng.ray.framework.module.asset.api.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import lombok.*;

import java.math.BigDecimal;

/**
 * 资产信息的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetInfoResponse extends BaseResponse {

    /**
     * 资产分类编号
     */
    private String categoryCode;

    /**
     * 资产分类名称
     */
    private String categoryName;

    /**
     * 使用人编号
     */
    private String userCode;

    /**
     * 使用人姓名
     */
    private String userName;

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
    private BigDecimal price;

    /**
     * 备注
     */
    private String remark;

}