package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产无法维修异常
 *
 * @author xuepeng
 */
public class AssetCannotRepairException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetCannotRepairException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetCannotRepairException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetCannotRepairException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetCannotRepairException(Throwable cause) {
        super(cause);
    }

}