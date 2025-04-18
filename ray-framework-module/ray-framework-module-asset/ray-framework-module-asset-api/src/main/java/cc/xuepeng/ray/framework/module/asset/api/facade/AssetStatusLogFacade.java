package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetStatusLogRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetStatusLogResponse;

import java.util.List;

/**
 * 资产状态日志的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetStatusLogFacade {

    /**
     * 根据资产编号查询状态日志
     *
     * @param assetCode 资产编号
     * @return 资产状态日志的响应对象集合
     */
    List<AssetStatusLogResponse> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产状态日志
     *
     * @param assetStatusLogRequest 资产状态日志的请求对象
     * @return 资产状态日志的响应对象
     */
    PageResponse<AssetStatusLogResponse> pageByCondition(AssetStatusLogRequest assetStatusLogRequest);

}