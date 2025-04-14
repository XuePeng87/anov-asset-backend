package cc.xuepeng.ray.framework.module.asset.api.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetScrapStatus;
import lombok.*;

/**
 * 资产报废的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetScrapResponse extends BaseResponse {

    /**
     * 报废编号
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