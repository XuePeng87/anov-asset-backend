package cc.xuepeng.ray.framework.module.asset.service.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetLoanStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * 资产借用的数据传输对象
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetLoanDto extends BaseDto {

    /**
     * 借用日期
     */
    private LocalDate loanDate;

    /**
     * 资产编号
     */
    private String assetCode;

    /**
     * 借用人编号
     */
    private String userCode;

    /**
     * 状态：0=借用；1=归还
     */
    private AssetLoanStatus status;

    /**
     * 备注
     */
    private String remark;

}