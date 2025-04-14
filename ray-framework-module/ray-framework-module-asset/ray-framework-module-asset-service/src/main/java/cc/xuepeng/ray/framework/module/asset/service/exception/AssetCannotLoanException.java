package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产无法借用异常
 *
 * @author xuepeng
 */
public class AssetCannotLoanException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetCannotLoanException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetCannotLoanException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetCannotLoanException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetCannotLoanException(Throwable cause) {
        super(cause);
    }

}