package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetRepairDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 资产维修的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetRepairService {

    /**
     * 创建资产维修记录
     *
     * @param assetRepairDto 资产维修的数据传输对象
     * @return 是否创建成功
     */
    boolean create(AssetRepairDto assetRepairDto);

    /**
     * 完成维修
     *
     * @param code   维修记录编号
     * @param remark 备注
     * @return 是否完成维修
     */
    boolean completeRepair(String code, String remark);

    /**
     * 根据编号查询资产维修记录
     *
     * @param code 资产维修记录的编号
     * @return 资产维修记录的数据传输对象
     */
    AssetRepairDto findByCode(String code);

    /**
     * 根据资产编号查询维修记录
     *
     * @param assetCode 资产编号
     * @return 资产维修记录的数据传输对象集合
     */
    List<AssetRepairDto> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产维修记录
     *
     * @param assetRepairDto 资产维修记录的数据传输对象
     * @return 资产维修记录的数据传输对象集合
     */
    Page<AssetRepairDto> pageByCondition(AssetRepairDto assetRepairDto);

}