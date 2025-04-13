package cc.xuepeng.ray.framework.module.asset.service.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 资产分类重复异常
 *
 * @author xuepeng
 */
public class AssetCategoryDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public AssetCategoryDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public AssetCategoryDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetCategoryDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public AssetCategoryDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}