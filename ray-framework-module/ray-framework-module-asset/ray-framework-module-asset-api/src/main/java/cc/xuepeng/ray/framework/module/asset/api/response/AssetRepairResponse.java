package cc.xuepeng.ray.framework.module.asset.api.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetRepairStatus;
import lombok.*;

/**
 * 资产维修的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetRepairResponse extends BaseResponse {

    /**
     * 维修编号
     */
    private String code;

    /**
     * 设备编号
     */
    private String assetCode;

    /**
     * 设备名称
     */
    private String assetName;

    /**
     * 维修原因
     */
    private String reason;

    /**
     * 状态：0=通过；1=驳回
     */
    private AssetRepairStatus status;

    /**
     * 备注
     */
    private String remark;

}