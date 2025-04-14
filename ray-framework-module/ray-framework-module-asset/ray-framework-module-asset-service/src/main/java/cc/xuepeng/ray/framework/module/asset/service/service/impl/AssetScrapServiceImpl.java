package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetScrap;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetScrapStatus;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetScrapRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetScrapEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetScrapDto;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetCannotScrapException;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetScrapNotFoundException;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetInfoService;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetScrapService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.sdk.auth.annotation.ModifyUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 资产报废的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetScrapServiceImpl
        extends ServiceImpl<AssetScrapRepository, AssetScrap>
        implements AssetScrapService {

    /**
     * 创建资产报废记录
     *
     * @param assetScrapDto 资产报废的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    @Transactional(rollbackFor = Exception.class)
    public boolean create(final AssetScrapDto assetScrapDto) {
        // 检查资产状态是否为在库
        AssetInfoDto assetInfo = assetInfoService.findByCode(assetScrapDto.getAssetCode());
        if (assetInfo.getStatus() != AssetStatus.IN_STOCK) {
            throw new AssetCannotScrapException("只有在库状态的资产才能报废");
        }

        assetScrapDto.setStatus(AssetScrapStatus.SCRAPPED);
        final AssetScrap assetScrap = assetScrapEntityConverter.dtoToEntity(assetScrapDto);
        boolean result = super.save(assetScrap);
        if (result) {
            assetInfoService.updateStatus(assetScrap.getAssetCode(), AssetStatus.SCRAPPED, "资产报废");
        }
        return result;
    }

    /**
     * 取消报废
     *
     * @param code   报废记录编号
     * @param remark 备注
     * @return 是否取消报废成功
     */
    @Override
    @ModifyUser
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelScrap(final String code, final String remark) {
        // 查询原始数据
        final AssetScrap originalAssetScrap = this.getByCode(code);
        if (ObjectUtils.isEmpty(originalAssetScrap)) {
            throw new AssetScrapNotFoundException("无法根据编号[" + code + "]查询到报废记录");
        }
        // 更新报废记录状态
        final AssetScrap assetScrap = new AssetScrap();
        assetScrap.setStatus(AssetScrapStatus.CANCELLED);
        assetScrap.setRemark(remark);
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper(code);
        boolean result = super.update(assetScrap, wrapper);
        // 更新资产状态为正常
        if (result) {
            assetInfoService.updateStatus(originalAssetScrap.getAssetCode(), AssetStatus.IN_USE, "取消报废");
        }
        return result;
    }

    /**
     * 根据编号查询资产报废记录
     *
     * @param code 资产报废记录的编号
     * @return 资产报废记录的数据传输对象
     */
    @Override
    public AssetScrapDto findByCode(final String code) {
        final AssetScrap assetScrap = this.getByCode(code);
        if (ObjectUtils.isEmpty(assetScrap)) {
            throw new AssetScrapNotFoundException("无法根据编号[" + code + "]查询到报废记录");
        }
        return assetScrapEntityConverter.entityToDto(assetScrap);
    }

    /**
     * 根据资产编号查询报废记录
     *
     * @param assetCode 资产编号
     * @return 资产报废记录的数据传输对象集合
     */
    @Override
    public List<AssetScrapDto> findByAssetCode(final String assetCode) {
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(AssetScrap::getAssetCode, assetCode);
        final List<AssetScrap> assetScraps = super.list(wrapper);
        return assetScrapEntityConverter.entityListToDtoList(assetScraps);
    }

    /**
     * 根据条件分页查询资产报废记录
     *
     * @param assetScrapDto 资产报废记录的数据传输对象
     * @return 资产报废记录的数据传输对象集合
     */
    @Override
    public Page<AssetScrapDto> pageByCondition(final AssetScrapDto assetScrapDto) {
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper(assetScrapDto);
        final Page<AssetScrap> page = PageUtil.createPage(assetScrapDto);
        final Page<AssetScrap> assetScraps = super.page(page, wrapper);
        return assetScrapEntityConverter.entityPageToDtoPage(assetScraps);
    }

    /**
     * 根据编号获取资产报废记录实体
     *
     * @param code 报废记录编号
     * @return 资产报废记录实体
     */
    private AssetScrap getByCode(final String code) {
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper(code);
        return super.getOne(wrapper);
    }

    /**
     * 创建QueryWrapper
     *
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetScrap> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建QueryWrapper
     *
     * @param code 报废记录编号
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetScrap> createQueryWrapper(final String code) {
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(AssetScrap::getCode, code);
        return wrapper;
    }

    /**
     * 创建QueryWrapper
     *
     * @param assetScrapDto 资产报废记录的数据传输对象
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetScrap> createQueryWrapper(final AssetScrapDto assetScrapDto) {
        final QueryWrapper<AssetScrap> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<AssetScrap> lambda = wrapper.lambda();
        // 根据编号模糊查询
        if (StringUtils.isNotEmpty(assetScrapDto.getCode())) {
            lambda.eq(AssetScrap::getCode, assetScrapDto.getCode());
        }
        // 根据资产编号模糊查询
        if (StringUtils.isNotEmpty(assetScrapDto.getAssetCode())) {
            lambda.eq(AssetScrap::getAssetCode, assetScrapDto.getAssetCode());
        }
        // 根据状态精确查询
        if (!ObjectUtils.isEmpty(assetScrapDto.getStatus())) {
            lambda.eq(AssetScrap::getStatus, assetScrapDto.getStatus());
        }
        // 排序
        lambda.orderByDesc(AssetScrap::getCreateTime);
        return wrapper;
    }

    /**
     * 资产报废记录实体转换器
     */
    @Resource
    private AssetScrapEntityConverter assetScrapEntityConverter;

    /**
     * 资产信息服务接口
     */
    @Resource
    private AssetInfoService assetInfoService;

}