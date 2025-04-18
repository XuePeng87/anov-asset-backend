package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetRepairRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetRepairResponse;

import java.util.List;

/**
 * 资产维修的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetRepairFacade {

    /**
     * 创建资产维修记录
     *
     * @param assetRepairRequest 资产维修的请求对象
     * @return 是否创建成功
     */
    boolean create(AssetRepairRequest assetRepairRequest);

    /**
     * 完成维修
     *
     * @param code   维修记录编号
     * @param result 维修结果
     * @return 是否完成维修
     */
    boolean completeRepair(String code, String result);

    /**
     * 根据编号查询资产维修记录
     *
     * @param code 资产维修记录的编号
     * @return 资产维修记录的响应对象
     */
    AssetRepairResponse findByCode(String code);

    /**
     * 根据资产编号查询维修记录
     *
     * @param assetCode 资产编号
     * @return 资产维修记录的响应对象集合
     */
    List<AssetRepairResponse> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产维修记录
     *
     * @param assetRepairRequest 资产维修记录的请求对象
     * @return 资产维修记录的响应对象
     */
    PageResponse<AssetRepairResponse> pageByCondition(AssetRepairRequest assetRepairRequest);

}