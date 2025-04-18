package cc.xuepeng.ray.framework.module.asset.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 资产状态日志的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetStatusLogRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 资产编号
     */
    @NotBlank(message = "资产编号不能为空", groups = {create.class})
    @Length(max = 32, message = "资产编号长度不能大于32个字符", groups = {create.class, page.class})
    private String assetCode;

    /**
     * 原状态：0=在库；1=使用；2=维修；3=报废
     */
    @NotNull(message = "原状态不能为空", groups = {create.class})
    private AssetStatus statusFrom;

    /**
     * 新状态：0=在库；1=使用；2=维修；3=报废
     */
    @NotNull(message = "新状态不能为空", groups = {create.class})
    private AssetStatus statusTo;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, page.class})
    private String remark;

}