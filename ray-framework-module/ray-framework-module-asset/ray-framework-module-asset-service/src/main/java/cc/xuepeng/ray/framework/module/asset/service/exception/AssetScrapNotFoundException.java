package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产报废记录未找到异常
 *
 * @author xuepeng
 */
public class AssetScrapNotFoundException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetScrapNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetScrapNotFoundException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetScrapNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetScrapNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}