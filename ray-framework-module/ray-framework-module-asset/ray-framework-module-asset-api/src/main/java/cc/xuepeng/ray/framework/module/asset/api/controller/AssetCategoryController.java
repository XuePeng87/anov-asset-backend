package cc.xuepeng.ray.framework.module.asset.api.controller;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.module.common.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.module.common.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetCategoryFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetCategoryRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetCategoryResponse;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产类别的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/asset-categories")
@Slf4j
@Validated
@SaCheckLogin
public class AssetCategoryController extends BaseController {

    /**
     * 创建资产类别
     *
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "创建类别", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final AssetCategoryRequest assetCategoryRequest
    ) {
        return assetCategoryFacade.create(assetCategoryRequest) ?
                DefaultResultFactory.success("创建资产类别成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建资产类别失败", Boolean.FALSE);
    }

    /**
     * 修改资产类别
     *
     * @param code                资产类别编号
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")




    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "修改类别", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.update.class) @RequestBody final AssetCategoryRequest assetCategoryRequest) {
        return assetCategoryFacade.update(code, assetCategoryRequest) ?
                DefaultResultFactory.success("修改资产类别成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改资产类别失败", Boolean.FALSE);
    }

    /**
     * 删除资产类别
     *
     * @param codes 资产类别编号集合
     * @return 是否删除成功
     */
    @DeleteMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "删除类别", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@RequestBody final List<String> codes) {
        return assetCategoryFacade.deleteByCodes(codes) ?
                DefaultResultFactory.success("删除资产类别成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除资产类别失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询资产类别
     *
     * @param code 资产类别编号
     * @return 资产类别的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "查询类别",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<AssetCategoryResponse> findByCode(@PathVariable(value = "code") final String code) {
        final AssetCategoryResponse result = assetCategoryFacade.findByCode(code);
        return DefaultResultFactory.success("查询资产类别成功", result);
    }

    /**
     * 分页查询资产类别
     *
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 资产类别的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "分页查询",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<AssetCategoryResponse>> pageByCondition(final AssetCategoryRequest assetCategoryRequest) {
        final PageResponse<AssetCategoryResponse> result = assetCategoryFacade.pageByCondition(assetCategoryRequest);
        return DefaultResultFactory.success("分页查询资产类别成功", result);
    }

    /**
     * 查询所有资产类别
     *
     * @return 资产类别的响应对象集合
     */
    @GetMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "资产管理", func = "资产类别", remark = "查询全部",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<AssetCategoryResponse>> findAll() {
        final List<AssetCategoryResponse> result = assetCategoryFacade.findAll();
        return DefaultResultFactory.success("查询所有资产类别成功", result);
    }

    /**
     * 资产类别的业务处理门面接口
     */
    @Resource
    private AssetCategoryFacade assetCategoryFacade;

}