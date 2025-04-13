package cc.xuepeng.ray.framework.module.asset.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetRepairStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 资产维修的数据传输对象
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetRepairDto extends BaseDto {

    /**
     * 设备编号
     */
    private String assetCode;

    /**
     * 报修时间
     */
    private LocalDate startDate;

    /**
     * 维修公司
     */
    private String company;

    /**
     * 维修费用
     */
    private BigDecimal cost;

    /**
     * 问题描述
     */
    private String faultCause;

    /**
     * 状态：0=待维修；1=维修中；2=已完成
     */
    private AssetRepairStatus status;

    /**
     * 维修结果
     */
    private String result;

    /**
     * 完成时间
     */
    private LocalDate endDate;

    /**
     * 备注
     */
    private String remark;

}