package cc.xuepeng.ray.framework.module.asset.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 资产分类的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetCategoryRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 编号
     */
    @NotBlank(message = "资产分类编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "资产分类编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "资产分类名称不能为空", groups = {create.class, update.class})
    @Length(max = 64, message = "资产分类名称长度不能大于64个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}