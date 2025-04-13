package cc.xuepeng.ray.framework.module.asset.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import lombok.*;

/**
 * 资产分类的数据传输对象
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetCategoryDto extends BaseDto {

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sequence;

}