package cc.xuepeng.ray.framework.module.asset.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetScrapStatus;
import lombok.*;

/**
 * 资产报废的数据传输对象
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetScrapDto extends BaseDto {

    /**
     * 借用编号
     */
    private String code;

    /**
     * 设备编号
     */
    private String assetCode;

    /**
     * 报废原因
     */
    private String reason;

    /**
     * 状态：0=通过；1=驳回
     */
    private AssetScrapStatus status;

    /**
     * 备注
     */
    private String remark;

}