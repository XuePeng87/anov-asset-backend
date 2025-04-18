package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetStatusLogFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetStatusLogRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetStatusLogResponse;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产状态日志的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/asset-status-logs")
@Slf4j
@Validated
@SaCheckLogin
public class AssetStatusLogController extends BaseController {

    /**
     * 根据资产编号查询状态日志
     *
     * @param assetCode 资产编号
     * @return 资产状态日志的响应对象集合
     */
    @GetMapping("/v1/asset/{assetCode}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "状态日志", remark = "查询资产状态日志",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<AssetStatusLogResponse>> findByAssetCode(@PathVariable(value = "assetCode") final String assetCode) {
        final List<AssetStatusLogResponse> result = assetStatusLogFacade.findByAssetCode(assetCode);
        return DefaultResultFactory.success("查询资产状态日志成功", result);
    }

    /**
     * 分页查询资产状态日志
     *
     * @param assetStatusLogRequest 资产状态日志的请求对象
     * @return 资产状态日志的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "状态日志", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetStatusLogResponse>> pageByCondition(final AssetStatusLogRequest assetStatusLogRequest) {
        final PageResponse<AssetStatusLogResponse> result = assetStatusLogFacade.pageByCondition(assetStatusLogRequest);
        return DefaultResultFactory.success("分页查询资产状态日志成功", result);
    }

    /**
     * 资产状态日志的业务处理门面接口
     */
    @Resource
    private AssetStatusLogFacade assetStatusLogFacade;

}