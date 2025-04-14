package cc.xuepeng.ray.framework.module.asset.api.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import lombok.*;

/**
 * 资产状态变更记录的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetStatusLogResponse extends BaseResponse {

    /**
     * 资产编号
     */
    private String assetCode;

    /**
     * 原状态：0=在库；1=使用；2=维修；3=报废
     */
    private AssetStatus statusFrom;

    /**
     * 新状态：0=在库；1=使用；2=维修；3=报废
     */
    private AssetStatus statusTo;

    /**
     * 备注
     */
    private String remark;

}