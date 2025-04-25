package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetInfoRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetInfoResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;

/**
 * 资产信息的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetInfoFacade {

    /**
     * 创建资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否创建成功
     */
    boolean create(final AssetInfoRequest assetInfoRequest);

    /**
     * 修改资产信息
     *
     * @param code 资产编号
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final AssetInfoRequest assetInfoRequest);

    /**
     * 根据编号查询资产信息
     *
     * @param code 资产信息的编号
     * @return 资产信息的响应对象
     */
    AssetInfoResponse findByCode(final String code);

    /**
     * 根据条件分页查询资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 资产信息的响应对象
     */
    PageResponse<AssetInfoResponse> pageByCondition(final AssetInfoRequest assetInfoRequest);

}