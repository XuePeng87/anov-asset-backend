package cc.xuepeng.ray.framework.module.asset.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetLoanStatus;
import lombok.*;

import java.time.LocalDate;

/**
 * 资产借用的实体类
 * 数据库表：asset_loan，资产借用表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetLoan extends BizEntity {

    /**
     * 借用日期
     * 数据库字段：loan_date，date
     */
    private LocalDate loanDate;

    /**
     * 资产编号
     * 数据库字段：asset_code，char(32)
     */
    private String assetCode;

    /**
     * 借用人编号
     * 数据库字段：user_code，char(32)
     */
    private String userCode;

    /**
     * 状态：0=借用；1=归还
     * 数据库字段：status，tinyint(1)
     */
    private AssetLoanStatus status;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}