package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetLoanDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 资产借用的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetLoanService {

    /**
     * 创建资产借用记录
     *
     * @param assetLoanDto 资产借用的数据传输对象
     * @return 是否创建成功
     */
    boolean loanAsset(AssetLoanDto assetLoanDto);

    /**
     * 归还资产
     *
     * @param assetLoanDto 资产借用的数据传输对象
     * @return 是否归还成功
     */
    boolean returnAsset(final AssetLoanDto assetLoanDto);

    /**
     * 根据资产编号查询借用记录
     *
     * @param assetCode 资产编号
     * @return 资产借用记录的数据传输对象集合
     */
    List<AssetLoanDto> findByAssetCode(String assetCode);

    /**
     * 根据条件分页查询资产借用记录
     *
     * @param assetLoanDto 资产借用记录的数据传输对象
     * @return 资产借用记录的数据传输对象集合
     */
    Page<AssetLoanDto> pageByCondition(AssetLoanDto assetLoanDto);

}