package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetLoanRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetLoanResponse;

import java.util.List;

/**
 * 资产借用的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetLoanFacade {

    /**
     * 创建资产借用记录
     *
     * @param assetLoanRequest 资产借用的请求对象
     * @return 是否创建成功
     */
    boolean loanAsset(AssetLoanRequest assetLoanRequest);

    /**
     * 归还资产
     *
     * @param assetLoanRequest 资产归还的请求对象
     * @return 是否归还成功
     */
    boolean returnAsset(AssetLoanRequest assetLoanRequest);

    /**
     * 根据资产编号查询借用记录
     *
     * @param assetCode 资产编号
     * @return 资产借用记录的响应对象集合
     */
    List<AssetLoanResponse> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产借用记录
     *
     * @param assetLoanRequest 资产借用记录的请求对象
     * @return 资产借用记录的响应对象
     */
    PageResponse<AssetLoanResponse> pageByCondition(AssetLoanRequest assetLoanRequest);

}