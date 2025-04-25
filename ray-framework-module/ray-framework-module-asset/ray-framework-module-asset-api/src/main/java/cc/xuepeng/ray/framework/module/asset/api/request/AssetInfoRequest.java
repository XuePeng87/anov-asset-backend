package cc.xuepeng.ray.framework.module.asset.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

/**
 * 资产信息的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetInfoRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 资产分类编号
     */
    @NotBlank(message = "资产分类编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "资产分类编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String categoryCode;

    /**
     * 使用人编号
     */
    private String userCode;

    /**
     * 名称
     */
    @NotBlank(message = "资产名称不能为空", groups = {create.class, update.class})
    @Length(max = 64, message = "资产名称长度不能大于64个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 品牌
     */
    @Length(max = 64, message = "品牌长度不能大于64个字符", groups = {create.class, update.class, page.class})
    private String brand;

    /**
     * 型号
     */
    @Length(max = 64, message = "型号长度不能大于64个字符", groups = {create.class, update.class, page.class})
    private String model;

    /**
     * 规格
     */
    @Length(max = 128, message = "规格长度不能大于128个字符", groups = {create.class, update.class, page.class})
    private String specification;

    /**
     * 状态：0=在库；1=使用；2=维修；3=报废
     */
    private AssetStatus status;

    /**
     * 存放位置
     */
    @Length(max = 128, message = "存放位置长度不能大于128个字符", groups = {create.class, update.class, page.class})
    private String location;

    /**
     * 采购年份
     */
    @Length(max = 4, message = "采购年份长度不能大于4个字符", groups = {create.class, update.class, page.class})
    private String purchaseYear;

    /**
     * 设备金额
     */
    private BigDecimal price;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}