package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产借用记录未找到异常
 *
 * @author xuepeng
 */
public class AssetLoanNotFoundException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetLoanNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetLoanNotFoundException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetLoanNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetLoanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}