package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetScrapRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetScrapResponse;

import java.util.List;

/**
 * 资产报废的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetScrapFacade {

    /**
     * 创建资产报废记录
     *
     * @param assetScrapRequest 资产报废的请求对象
     * @return 是否创建成功
     */
    boolean create(AssetScrapRequest assetScrapRequest);

    /**
     * 取消报废
     *
     * @param code   报废记录编号
     * @param remark 备注
     * @return 是否取消报废成功
     */
    boolean cancelScrap(String code, String remark);

    /**
     * 根据编号查询资产报废记录
     *
     * @param code 资产报废记录的编号
     * @return 资产报废记录的响应对象
     */
    AssetScrapResponse findByCode(String code);

    /**
     * 根据资产编号查询报废记录
     *
     * @param assetCode 资产编号
     * @return 资产报废记录的响应对象集合
     */
    List<AssetScrapResponse> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产报废记录
     *
     * @param assetScrapRequest 资产报废记录的请求对象
     * @return 资产报废记录的响应对象
     */
    PageResponse<AssetScrapResponse> pageByCondition(AssetScrapRequest assetScrapRequest);

}