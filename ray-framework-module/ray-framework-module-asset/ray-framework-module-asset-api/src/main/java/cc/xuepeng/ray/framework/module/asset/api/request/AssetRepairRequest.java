package cc.xuepeng.ray.framework.module.asset.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetRepairStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 资产维修的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetRepairRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 设备编号
     */
    @NotBlank(message = "设备编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "设备编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String assetCode;

    /**
     * 维修原因
     */
    @NotBlank(message = "维修原因不能为空", groups = {create.class, update.class})
    @Length(max = 256, message = "维修原因长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String reason;

    /**
     * 状态：0=通过；1=驳回
     */
    @NotNull(message = "维修状态不能为空", groups = {create.class, update.class})
    private AssetRepairStatus status;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}