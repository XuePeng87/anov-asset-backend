package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetInfoFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetInfoRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetInfoResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 资产信息的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/assets")
@Slf4j
@Validated
@SaCheckLogin
public class AssetInfoController extends BaseController {

    /**
     * 创建资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产信息", remark = "创建资产", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetInfoRequest assetInfoRequest
    ) {
        return assetInfoFacade.create(assetInfoRequest) ?
                DefaultResultFactory.success("创建资产信息成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建资产信息失败", Boolean.FALSE);
    }

    /**
     * 修改资产信息
     *
     * @param code            资产编号
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产信息", remark = "修改资产", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.update.class) @RequestBody final AssetInfoRequest assetInfoRequest) {
        return assetInfoFacade.update(code, assetInfoRequest) ?
                DefaultResultFactory.success("修改资产信息成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改资产信息失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询资产信息
     *
     * @param code 资产编号
     * @return 资产信息的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产信息", remark = "查询资产",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<AssetInfoResponse> findByCode(@PathVariable(value = "code") final String code) {
        final AssetInfoResponse result = assetInfoFacade.findByCode(code);
        return DefaultResultFactory.success("查询资产信息成功", result);
    }

    /**
     * 分页查询资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 资产信息的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产信息", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetInfoResponse>> pageByCondition(final AssetInfoRequest assetInfoRequest) {
        final PageResponse<AssetInfoResponse> result = assetInfoFacade.pageByCondition(assetInfoRequest);
        return DefaultResultFactory.success("分页查询资产信息成功", result);
    }

    /**
     * 资产信息的业务处理门面接口
     */
    @Resource
    private AssetInfoFacade assetInfoFacade;

}