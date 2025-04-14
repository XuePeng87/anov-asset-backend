package cc.xuepeng.ray.framework.module.asset.api.exception;

import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.module.asset.service.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资产管理模块的异常处理器
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class AssetExceptionHandler {

    /**
     * AssetCategoryDuplicateException异常处理，返回错误信息和错误代码
     * 代码为51010，错误信息为"资产分类已存在"
     *
     * @param e AssetCategoryDuplicateException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetCategoryDuplicateException.class)
    @ResponseBody
    public Result<String> assetCategoryDuplicateExceptionHandler(AssetCategoryDuplicateException e) {
        log.error("资产分类已存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.CATEGORY_DUPLICATE).msg(e.getMessage()).build();
    }

    /**
     * AssetCategoryNotFoundException异常处理，返回错误信息和错误代码
     * 代码为51011，错误信息为"资产分类不存在"
     *
     * @param e AssetCategoryNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetCategoryNotFoundException.class)
    @ResponseBody
    public Result<String> assetCategoryNotFoundExceptionHandler(AssetCategoryNotFoundException e) {
        log.error("资产分类不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.CATEGORY_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * AssetInfoNotFoundException异常处理，返回错误信息和错误代码
     * 代码为51020，错误信息为"资产不存在"
     *
     * @param e AssetInfoNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetInfoNotFoundException.class)
    @ResponseBody
    public Result<String> assetInfoNotFoundExceptionHandler(AssetInfoNotFoundException e) {
        log.error("资产不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * AssetCannotScrapException异常处理，返回错误信息和错误代码
     * 代码为51030，错误信息为"资产不能报废"
     *
     * @param e AssetCannotScrapException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetCannotScrapException.class)
    @ResponseBody
    public Result<String> assetCannotScrapExceptionHandler(AssetCannotScrapException e) {
        log.error("资产不能报废 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_CANNOT_SCRAP).msg(e.getMessage()).build();
    }

    /**
     * AssetScrapNotFoundException异常处理，返回错误信息和错误代码
     * 代码为51031，错误信息为"资产报废记录不存在"
     *
     * @param e AssetScrapNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetScrapNotFoundException.class)
    @ResponseBody
    public Result<String> assetScrapNotFoundExceptionHandler(AssetScrapNotFoundException e) {
        log.error("资产报废记录不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_SCRAP_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * AssetCannotRepairException异常处理，返回错误信息和错误代码
     * 代码为51040，错误信息为"资产不能维修"
     *
     * @param e AssetCannotRepairException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetCannotRepairException.class)
    @ResponseBody
    public Result<String> assetCannotRepairExceptionHandler(AssetCannotRepairException e) {
        log.error("资产不能维修 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_CANNOT_REPAIR).msg(e.getMessage()).build();
    }

    /**
     * AssetRepairNotFoundException异常处理，返回错误信息和错误代码
     * 代码为51041，错误信息为"资产维修记录不存在"
     *
     * @param e AssetRepairNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetRepairNotFoundException.class)
    @ResponseBody
    public Result<String> assetRepairNotFoundExceptionHandler(AssetRepairNotFoundException e) {
        log.error("资产维修记录不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_REPAIR_NOT_FOUND).msg(e.getMessage()).build();
    }

    /**
     * AssetCannotLoanException异常处理，返回错误信息和错误代码
     * 代码为51050，错误信息为"资产不能借用"
     *
     * @param e AssetCannotLoanException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetCannotLoanException.class)
    @ResponseBody
    public Result<String> assetCannotLoanExceptionHandler(AssetCannotLoanException e) {
        log.error("资产不能借用 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_CANNOT_LOAN).msg(e.getMessage()).build();
    }

    /**
     * AssetLoanNotFoundException异常处理，返回错误信息和错误代码
     * 代码为51051，错误信息为"资产借用记录不存在"
     *
     * @param e AssetLoanNotFoundException异常
     * @return 错误信息和错误代码
     */
    @ExceptionHandler(value = AssetLoanNotFoundException.class)
    @ResponseBody
    public Result<String> assetLoanNotFoundExceptionHandler(AssetLoanNotFoundException e) {
        log.error("资产借用记录不存在 -> {}", e.getMessage());
        return new Result.Builder<String>(AssetResultStatus.ASSET_LOAN_NOT_FOUND).msg(e.getMessage()).build();
    }

}