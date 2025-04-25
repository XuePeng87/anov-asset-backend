package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 资产信息的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetInfoService {

    /**
     * 创建资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final AssetInfoDto assetInfoDto);

    /**
     * 修改资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final AssetInfoDto assetInfoDto);

    /**
     * 更新资产状态
     *
     * @param code     资产编号
     * @param userCode 用户编号
     * @param status   资产状态
     * @param remark   备注
     */
    void updateStatus(final String code, final String userCode, final AssetStatus status, final String remark);

    /**
     * 根据编号查询资产信息
     *
     * @param code 资产信息的编号
     * @return 资产信息的数据传输对象
     */
    AssetInfoDto findByCode(final String code);

    /**
     * 根据条件分页查询资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 资产信息的数据传输对象集合
     */
    Page<AssetInfoDto> pageByCondition(final AssetInfoDto assetInfoDto);

}