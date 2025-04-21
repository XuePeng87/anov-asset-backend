package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetRepair;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetRepairStatus;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetRepairRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetRepairEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetRepairDto;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetCannotRepairException;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetRepairNotFoundException;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetInfoService;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetRepairService;
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

import java.time.LocalDate;
import java.util.List;

/**
 * 资产维修的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetRepairServiceImpl
        extends ServiceImpl<AssetRepairRepository, AssetRepair>
        implements AssetRepairService {

    /**
     * 创建资产维修记录
     *
     * @param assetRepairDto 资产维修的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    @Transactional(rollbackFor = Exception.class)
    public boolean create(final AssetRepairDto assetRepairDto) {
        // 检查资产状态是否为在库
        AssetInfoDto assetInfoDto = assetInfoService.findByCode(assetRepairDto.getAssetCode());
        if (assetInfoDto.getStatus() != AssetStatus.IN_STOCK) {
            throw new AssetCannotRepairException("只有在库状态的资产才能维修");
        }
        assetRepairDto.setCode(RandomUtil.get32UUID());
        // 设置初始状态为维修中
        assetRepairDto.setStatus(AssetRepairStatus.REPAIRING);
        assetRepairDto.setStartDate(LocalDate.now());
        final AssetRepair assetRepair = assetRepairEntityConverter.dtoToEntity(assetRepairDto);
        // 更新资产状态为维修中
        assetInfoService.updateStatus(assetRepairDto.getAssetCode(), AssetStatus.UNDER_REPAIR, "资产维修");
        return super.save(assetRepair);
    }

    /**
     * 完成维修
     *
     * @param code   维修记录编号
     * @param result 维修结果
     * @return 是否完成维修
     */
    @Override
    @ModifyUser
    @Transactional(rollbackFor = Exception.class)
    public boolean completeRepair(final String code, final String result) {
        // 查询原始数据
        final AssetRepair originalAssetRepair = this.getByCode(code);
        if (ObjectUtils.isEmpty(originalAssetRepair)) {
            throw new AssetRepairNotFoundException("无法根据编号[" + code + "]查询到维修记录");
        }
        // 更新维修记录状态
        final AssetRepair assetRepair = new AssetRepair();
        assetRepair.setStatus(AssetRepairStatus.COMPLETED);
        assetRepair.setEndDate(LocalDate.now());
        assetRepair.setResult(result);
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper(code);
        boolean ret = super.update(assetRepair, wrapper);
        // 更新资产状态为在库
        if (ret) {
            assetInfoService.updateStatus(originalAssetRepair.getAssetCode(), AssetStatus.IN_STOCK, "维修完成");
        }
        return ret;
    }

    /**
     * 根据编号查询资产维修记录
     *
     * @param code 资产维修记录的编号
     * @return 资产维修记录的数据传输对象
     */
    @Override
    public AssetRepairDto findByCode(final String code) {
        final AssetRepair assetRepair = this.getByCode(code);
        if (ObjectUtils.isEmpty(assetRepair)) {
            throw new AssetRepairNotFoundException("无法根据编号[" + code + "]查询到维修记录");
        }
        return assetRepairEntityConverter.entityToDto(assetRepair);
    }

    /**
     * 根据资产编号查询维修记录
     *
     * @param assetCode 资产编号
     * @return 资产维修记录的数据传输对象集合
     */
    @Override
    public List<AssetRepairDto> findByAssetCode(final String assetCode) {
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(AssetRepair::getAssetCode, assetCode);
        final List<AssetRepair> assetRepairs = super.list(wrapper);
        return assetRepairEntityConverter.entityListToDtoList(assetRepairs);
    }

    /**
     * 根据条件分页查询资产维修记录
     *
     * @param assetRepairDto 资产维修记录的数据传输对象
     * @return 资产维修记录的数据传输对象集合
     */
    @Override
    public Page<AssetRepairDto> pageByCondition(final AssetRepairDto assetRepairDto) {
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper(assetRepairDto);
        final Page<AssetRepair> page = PageUtil.createPage(assetRepairDto);
        final Page<AssetRepair> assetRepairs = super.page(page, wrapper);
        return assetRepairEntityConverter.entityPageToDtoPage(assetRepairs);
    }

    /**
     * 根据编号获取资产维修记录实体
     *
     * @param code 维修记录编号
     * @return 资产维修记录实体
     */
    private AssetRepair getByCode(final String code) {
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper(code);
        return super.getOne(wrapper);
    }

    /**
     * 创建QueryWrapper
     *
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetRepair> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建QueryWrapper
     *
     * @param code 维修记录编号
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetRepair> createQueryWrapper(final String code) {
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(AssetRepair::getCode, code);
        return wrapper;
    }

    /**
     * 创建QueryWrapper
     *
     * @param assetRepairDto 资产维修记录的数据传输对象
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetRepair> createQueryWrapper(final AssetRepairDto assetRepairDto) {
        final QueryWrapper<AssetRepair> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<AssetRepair> lambda = wrapper.lambda();
        // 根据编号模糊查询
        if (StringUtils.isNotEmpty(assetRepairDto.getCode())) {
            lambda.eq(AssetRepair::getCode, assetRepairDto.getCode());
        }
        // 根据资产编号模糊查询
        if (StringUtils.isNotEmpty(assetRepairDto.getAssetCode())) {
            lambda.eq(AssetRepair::getAssetCode, assetRepairDto.getAssetCode());
        }
        // 根据状态精确查询
        if (!ObjectUtils.isEmpty(assetRepairDto.getStatus())) {
            lambda.eq(AssetRepair::getStatus, assetRepairDto.getStatus());
        }
        // 排序
        lambda.orderByDesc(AssetRepair::getCreateTime);
        return wrapper;
    }

    /**
     * 资产维修记录实体转换器
     */
    @Resource
    private AssetRepairEntityConverter assetRepairEntityConverter;

    /**
     * 资产信息服务接口
     */
    @Resource
    private AssetInfoService assetInfoService;

}