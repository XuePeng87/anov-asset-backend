package cc.xuepeng.ray.framework.module.asset.service.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 资产分类未找到异常
 *
 * @author xuepeng
 */
public class AssetCategoryNotFoundException extends BaseException {

    /**
     * 构造函数
     */
    public AssetCategoryNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public AssetCategoryNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public AssetCategoryNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}