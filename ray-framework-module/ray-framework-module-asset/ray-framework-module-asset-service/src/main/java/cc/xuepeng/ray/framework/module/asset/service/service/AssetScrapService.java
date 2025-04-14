package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetScrapDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 资产报废的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetScrapService {

    /**
     * 创建资产报废记录
     *
     * @param assetScrapDto 资产报废的数据传输对象
     * @return 是否创建成功
     */
    boolean create(AssetScrapDto assetScrapDto);

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
     * @return 资产报废记录的数据传输对象
     */
    AssetScrapDto findByCode(String code);

    /**
     * 根据资产编号查询报废记录
     *
     * @param assetCode 资产编号
     * @return 资产报废记录的数据传输对象集合
     */
    List<AssetScrapDto> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产报废记录
     *
     * @param assetScrapDto 资产报废记录的数据传输对象
     * @return 资产报废记录的数据传输对象集合
     */
    Page<AssetScrapDto> pageByCondition(AssetScrapDto assetScrapDto);

}