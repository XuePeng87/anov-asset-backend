package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 资产状态日志的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetStatusLogService {

    /**
     * 创建资产状态变更日志
     *
     * @param assetStatusLogDto 资产状态日志的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final AssetStatusLogDto assetStatusLogDto);

    /**
     * 根据资产编号查询状态变更日志
     *
     * @param assetCode 资产编号
     * @return 资产状态日志的数据传输对象集合
     */
    List<AssetStatusLogDto> findByAssetCode(final String assetCode);

    /**
     * 根据条件分页查询资产状态日志
     *
     * @param assetStatusLogDto 资产状态日志的数据传输对象
     * @return 资产状态日志的数据传输对象集合
     */
    Page<AssetStatusLogDto> pageByCondition(final AssetStatusLogDto assetStatusLogDto);

}