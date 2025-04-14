package cc.xuepeng.ray.framework.module.asset.api.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import lombok.*;

/**
 * 资产分类的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetCategoryResponse extends BaseResponse {

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

}