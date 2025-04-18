package cc.xuepeng.ray.framework.module.asset.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetLoanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 资产借用的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetLoanRequest extends BaseRequest implements RequestValidateScope {

    @NotBlank(message = "借用人编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "借用人编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String userCode;

    /**
     * 设备编号
     */
    @NotBlank(message = "设备编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "设备编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String assetCode;

    /**
     * 借用原因
     */
    @NotBlank(message = "借用原因不能为空", groups = {create.class, update.class})
    @Length(max = 256, message = "借用原因长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String reason;

    /**
     * 状态：0=通过；1=驳回
     */
    @NotNull(message = "借用状态不能为空", groups = {create.class, update.class})
    private AssetLoanStatus status;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}