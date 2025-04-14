package cc.xuepeng.ray.framework.module.asset.service.exception;

/**
 * 资产维修记录未找到异常
 *
 * @author xuepeng
 */
public class AssetRepairNotFoundException extends RuntimeException {

    /**
     * 构造函数
     */
    public AssetRepairNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public AssetRepairNotFoundException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public AssetRepairNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param cause   异常原因
     */
    public AssetRepairNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}