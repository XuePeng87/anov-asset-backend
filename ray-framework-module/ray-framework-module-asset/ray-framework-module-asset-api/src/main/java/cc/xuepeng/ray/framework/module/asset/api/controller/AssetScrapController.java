package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetScrapFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetScrapRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetScrapResponse;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产报废的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/asset-scraps")
@Slf4j
@Validated
@SaCheckLogin
public class AssetScrapController extends BaseController {

    /**
     * 创建资产报废记录
     *
     * @param assetScrapRequest 资产报废的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产报废", remark = "创建报废", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetScrapRequest assetScrapRequest
    ) {
        return assetScrapFacade.create(assetScrapRequest) ?
                DefaultResultFactory.success("创建资产报废记录成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建资产报废记录失败", Boolean.FALSE);
    }

    /**
     * 取消报废
     *
     * @param code   报废记录编号
     * @param remark 备注
     * @return 是否取消报废成功
     */
    @PutMapping("/v1/{code}/cancel")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产报废", remark = "取消报废", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> cancelScrap(
            @PathVariable(value = "code") final String code,
            @RequestParam(value = "remark", required = false) final String remark) {
        return assetScrapFacade.cancelScrap(code, remark) ?
                DefaultResultFactory.success("取消报废成功", Boolean.TRUE) :
                DefaultResultFactory.fail("取消报废失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询资产报废记录
     *
     * @param code 资产报废记录编号
     * @return 资产报废记录的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产报废", remark = "查询报废",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<AssetScrapResponse> findByCode(@PathVariable(value = "code") final String code) {
        final AssetScrapResponse result = assetScrapFacade.findByCode(code);
        return DefaultResultFactory.success("查询资产报废记录成功", result);
    }

    /**
     * 根据资产编号查询报废记录
     *
     * @param assetCode 资产编号
     * @return 资产报废记录的响应对象集合
     */
    @GetMapping("/v1/asset/{assetCode}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产报废", remark = "查询资产报废记录",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<AssetScrapResponse>> findByAssetCode(@PathVariable(value = "assetCode") final String assetCode) {
        final List<AssetScrapResponse> result = assetScrapFacade.findByAssetCode(assetCode);
        return DefaultResultFactory.success("查询资产报废记录成功", result);
    }

    /**
     * 分页查询资产报废记录
     *
     * @param assetScrapRequest 资产报废记录的请求对象
     * @return 资产报废记录的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产报废", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetScrapResponse>> pageByCondition(final AssetScrapRequest assetScrapRequest) {
        final PageResponse<AssetScrapResponse> result = assetScrapFacade.pageByCondition(assetScrapRequest);
        return DefaultResultFactory.success("分页查询资产报废记录成功", result);
    }

    /**
     * 资产报废的业务处理门面接口
     */
    @Resource
    private AssetScrapFacade assetScrapFacade;

}