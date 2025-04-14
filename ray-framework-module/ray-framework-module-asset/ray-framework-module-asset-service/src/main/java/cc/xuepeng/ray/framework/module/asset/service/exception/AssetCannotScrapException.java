package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产无法报废异常
 *
 * @author xuepeng
 */
public class AssetCannotScrapException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetCannotScrapException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetCannotScrapException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetCannotScrapException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetCannotScrapException(Throwable cause) {
        super(cause);
    }

}