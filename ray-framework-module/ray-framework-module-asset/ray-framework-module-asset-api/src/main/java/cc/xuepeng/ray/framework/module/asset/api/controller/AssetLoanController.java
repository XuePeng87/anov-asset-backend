package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetLoanFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetLoanRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetLoanResponse;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产借用的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/asset-loans")
@Slf4j
@Validated
@SaCheckLogin
public class AssetLoanController extends BaseController {

    /**
     * 创建资产借用记录
     *
     * @param assetLoanRequest 资产借用的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1/loan")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产借用", remark = "创建借用", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetLoanRequest assetLoanRequest
    ) {
        return assetLoanFacade.loanAsset(assetLoanRequest) ?
                DefaultResultFactory.success("创建资产借用记录成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建资产借用记录失败", Boolean.FALSE);
    }

    /**
     * 归还资产
     *
     * @param assetLoanRequest 资产归还的请求对象
     * @return 是否归还成功
     */
    @PostMapping("/v1/return")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产借用", remark = "归还资产", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> returnAsset(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetLoanRequest assetLoanRequest
    ) {
        return assetLoanFacade.returnAsset(assetLoanRequest) ?
                DefaultResultFactory.success("归还资产成功", Boolean.TRUE) :
                DefaultResultFactory.fail("归还资产失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询资产借用记录
     *
     * @param code 资产借用记录编号
     * @return 资产借用记录的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产借用", remark = "查询借用",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<AssetLoanResponse> findByCode(@PathVariable(value = "code") final String code) {
        final AssetLoanResponse result = assetLoanFacade.findByCode(code);
        return DefaultResultFactory.success("查询资产借用记录成功", result);
    }

    /**
     * 根据资产编号查询借用记录
     *
     * @param assetCode 资产编号
     * @return 资产借用记录的响应对象集合
     */
    @GetMapping("/v1/asset/{assetCode}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产借用", remark = "查询资产借用记录",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<AssetLoanResponse>> findByAssetCode(@PathVariable(value = "assetCode") final String assetCode) {
        final List<AssetLoanResponse> result = assetLoanFacade.findByAssetCode(assetCode);
        return DefaultResultFactory.success("查询资产借用记录成功", result);
    }

    /**
     * 分页查询资产借用记录
     *
     * @param assetLoanRequest 资产借用记录的请求对象
     * @return 资产借用记录的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产借用", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetLoanResponse>> pageByCondition(final AssetLoanRequest assetLoanRequest) {
        final PageResponse<AssetLoanResponse> result = assetLoanFacade.pageByCondition(assetLoanRequest);
        return DefaultResultFactory.success("分页查询资产借用记录成功", result);
    }

    /**
     * 资产借用的业务处理门面接口
     */
    @Resource
    private AssetLoanFacade assetLoanFacade;

}