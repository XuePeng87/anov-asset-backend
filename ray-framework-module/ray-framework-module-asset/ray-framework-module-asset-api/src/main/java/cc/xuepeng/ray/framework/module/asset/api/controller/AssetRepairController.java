package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetRepairFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetRepairRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetRepairResponse;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产维修的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/asset-repairs")
@Slf4j
@Validated
@SaCheckLogin
public class AssetRepairController extends BaseController {

    /**
     * 创建资产维修记录
     *
     * @param assetRepairRequest 资产维修的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产维修", remark = "创建维修", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetRepairRequest assetRepairRequest
    ) {
        return assetRepairFacade.create(assetRepairRequest) ?
                DefaultResultFactory.success("创建资产维修记录成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建资产维修记录失败", Boolean.FALSE);
    }

    /**
     * 完成维修
     *
     * @param code   维修记录编号
     * @param remark 备注
     * @return 是否完成维修成功
     */
    @PutMapping("/v1/{code}/complete")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产维修", remark = "完成维修", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> completeRepair(
            @PathVariable(value = "code") final String code,
            @RequestParam(value = "remark", required = false) final String remark) {
        return assetRepairFacade.completeRepair(code, remark) ?
                DefaultResultFactory.success("完成维修成功", Boolean.TRUE) :
                DefaultResultFactory.fail("完成维修失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询资产维修记录
     *
     * @param code 资产维修记录编号
     * @return 资产维修记录的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产维修", remark = "查询维修",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<AssetRepairResponse> findByCode(@PathVariable(value = "code") final String code) {
        final AssetRepairResponse result = assetRepairFacade.findByCode(code);
        return DefaultResultFactory.success("查询资产维修记录成功", result);
    }

    /**
     * 根据资产编号查询维修记录
     *
     * @param assetCode 资产编号
     * @return 资产维修记录的响应对象集合
     */
    @GetMapping("/v1/asset/{assetCode}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产维修", remark = "查询资产维修记录",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<AssetRepairResponse>> findByAssetCode(@PathVariable(value = "assetCode") final String assetCode) {
        final List<AssetRepairResponse> result = assetRepairFacade.findByAssetCode(assetCode);
        return DefaultResultFactory.success("查询资产维修记录成功", result);
    }

    /**
     * 分页查询资产维修记录
     *
     * @param assetRepairRequest 资产维修记录的请求对象
     * @return 资产维修记录的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产维修", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetRepairResponse>> pageByCondition(final AssetRepairRequest assetRepairRequest) {
        final PageResponse<AssetRepairResponse> result = assetRepairFacade.pageByCondition(assetRepairRequest);
        return DefaultResultFactory.success("分页查询资产维修记录成功", result);
    }

    /**
     * 资产维修的业务处理门面接口
     */
    @Resource
    private AssetRepairFacade assetRepairFacade;

}