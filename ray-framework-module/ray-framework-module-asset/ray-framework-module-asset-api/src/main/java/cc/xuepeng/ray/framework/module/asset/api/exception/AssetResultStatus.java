package cc.xuepeng.ray.framework.module.asset.api.exception;

import cc.xuepeng.ray.framework.core.common.domain.result.ResultStatus;

/**
 * 资产管理异常响应状态
 * 资产分类错误编码：51010 - 51019
 * 资产错误编码：51020 - 51029
 * 资产报废错误编码：51030 - 51039
 * 资产维修错误编码：51040 - 51049
 * 资产借用错误编码：51050 - 51059
 *
 * @author xuepeng
 */
public enum AssetResultStatus implements ResultStatus {

    /**
     * AssetCategoryDuplicateException的状态
     */
    CATEGORY_DUPLICATE(51010, "资产分类已存在"),

    /**
     * AssetCategoryNotFoundException的状态
     */
    CATEGORY_NOT_FOUND(51011, "资产分类不存在"),

    /**
     * AssetInfoNotFoundException的状态
     */
    ASSET_NOT_FOUND(51020, "资产不存在"),

    /**
     * AssetCannotScrapException的状态
     */
    ASSET_CANNOT_SCRAP(51030, "资产不能报废"),

    /**
     * AssetScrapNotFoundException的状态
     */
    ASSET_SCRAP_NOT_FOUND(51031, "资产报废记录不存在"),

    /**
     * AssetCannotRepairException的状态
     */
    ASSET_CANNOT_REPAIR(51040, "资产不能维修"),

    /**
     * AssetRepairNotFoundException的状态
     */
    ASSET_REPAIR_NOT_FOUND(51041, "资产维修记录不存在"),

    /**
     * AssetCannotLoanException的状态
     */
    ASSET_CANNOT_LOAN(51050, "资产不能借用"),

    /**
     * AssetLoanNotFoundException的状态
     */
    ASSET_LOAN_NOT_FOUND(51051, "资产借用记录不存在");

    /**
     * 构造函数
     *
     * @param code 状态编号
     * @param desc 状态描述
     */
    AssetResultStatus(final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @return 获取状态编号
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * @return 获取状态描述
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 状态编号
     */
    private final int code;

    /**
     * 状态描述
     */
    private final String desc;

}