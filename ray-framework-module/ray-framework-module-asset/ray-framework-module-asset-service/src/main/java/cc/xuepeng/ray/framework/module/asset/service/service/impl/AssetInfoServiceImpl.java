package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetInfo;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetInfoRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetInfoEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.decorator.AssetInfoDtoDecorator;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetInfoNotFoundException;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetInfoService;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetStatusLogService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.sdk.auth.annotation.ModifyUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资产信息的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetInfoServiceImpl
        extends ServiceImpl<AssetInfoRepository, AssetInfo>
        implements AssetInfoService {

    /**
     * 创建资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final AssetInfoDto assetInfoDto) {
        // 设置初始状态为在库
        assetInfoDto.setStatus(AssetStatus.IN_STOCK);
        assetInfoDto.setCode(RandomUtil.get32UUID());
        final AssetInfo assetInfo = assetInfoEntityConverter.dtoToEntity(assetInfoDto);
        return super.save(assetInfo);
    }

    /**
     * 修改资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    @Transactional(rollbackFor = Exception.class)
    public boolean update(final AssetInfoDto assetInfoDto) {
        final String code = assetInfoDto.getCode();
        // 查询原始数据
        final AssetInfo originalAssetInfo = this.getByCode(code);
        if (ObjectUtils.isEmpty(originalAssetInfo)) {
            throw new AssetInfoNotFoundException("无法根据编号[" + code + "]查询到资产信息");
        }

        // 如果状态发生变更，则记录状态变更日志
        if (assetInfoDto.getStatus() != null &&
                !assetInfoDto.getStatus().equals(originalAssetInfo.getStatus())) {
            final AssetStatusLogDto assetStatusLogDto = new AssetStatusLogDto();
            assetStatusLogDto.setAssetCode(code);
            assetStatusLogDto.setStatusFrom(originalAssetInfo.getStatus());
            assetStatusLogDto.setStatusTo(assetInfoDto.getStatus());
            assetStatusLogService.create(assetStatusLogDto);
        }
        final AssetInfo assetInfo = assetInfoEntityConverter.dtoToEntity(assetInfoDto);
        final QueryWrapper<AssetInfo> wrapper = this.createQueryWrapper(code);
        return super.update(assetInfo, wrapper);
    }

    /**
     * 更新资产状态
     *
     * @param code   资产编号
     * @param status 资产状态
     * @param remark 备注
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStatus(final String code, final AssetStatus status, final String remark) {
        // 查询原始数据
        final AssetInfo originalAssetInfo = this.getByCode(code);
        if (ObjectUtils.isEmpty(originalAssetInfo)) {
            throw new AssetInfoNotFoundException("无法根据编号[" + code + "]查询到资产信息");
        }
        // 如果状态未发生变化，则不需要更新
        if (status.equals(originalAssetInfo.getStatus())) {
            return true;
        }
        // 记录状态变更日志
        final AssetStatusLogDto assetStatusLogDto = new AssetStatusLogDto();
        assetStatusLogDto.setAssetCode(code);
        assetStatusLogDto.setStatusFrom(originalAssetInfo.getStatus());
        assetStatusLogDto.setStatusTo(status);
        assetStatusLogService.create(assetStatusLogDto);
        // 更新资产状态
        final AssetInfo assetInfo = new AssetInfo();
        assetInfo.setStatus(status);
        final QueryWrapper<AssetInfo> wrapper = this.createQueryWrapper(code);
        return super.update(assetInfo, wrapper);
    }

    /**
     * 根据编号查询资产信息
     *
     * @param code 资产信息的编号
     * @return 资产信息的数据传输对象
     */
    @Override
    public AssetInfoDto findByCode(final String code) {
        final AssetInfo assetInfo = this.getByCode(code);
        if (ObjectUtils.isEmpty(assetInfo)) {
            throw new AssetInfoNotFoundException("无法根据编号[" + code + "]查询到资产信息");
        }
        return assetInfoEntityConverter.entityToDto(assetInfo);
    }

    /**
     * 根据条件分页查询资产信息
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 资产信息的数据传输对象集合
     */
    @Override
    public Page<AssetInfoDto> pageByCondition(final AssetInfoDto assetInfoDto) {
        final QueryWrapper<AssetInfo> wrapper = this.createQueryWrapper(assetInfoDto);
        final Page<AssetInfo> page = PageUtil.createPage(assetInfoDto);
        final Page<AssetInfo> assetInfos = super.page(page, wrapper);
        return assetInfoDtoDecorator.decorate(
                assetInfoEntityConverter.entityPageToDtoPage(assetInfos)
        );
    }

    /**
     * 根据编号获取资产信息实体
     *
     * @param code 资产编号
     * @return 资产信息实体
     */
    private AssetInfo getByCode(final String code) {
        final QueryWrapper<AssetInfo> wrapper = this.createQueryWrapper(code);
        return super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<AssetInfo> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 资产信息的编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<AssetInfo> createQueryWrapper(final String code) {
        final QueryWrapper<AssetInfo> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<AssetInfo> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), AssetInfo::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param assetInfoDto 资产信息的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<AssetInfo> createQueryWrapper(final AssetInfoDto assetInfoDto) {
        final QueryWrapper<AssetInfo> wrapper = QueryWrapperUtil.createQueryWrapper(assetInfoDto);
        final AssetInfo assetInfo = assetInfoEntityConverter.dtoToEntity(assetInfoDto);
        final LambdaQueryWrapper<AssetInfo> lambda = wrapper.lambda();

        // 增加条件查询
        lambda.like(StringUtils.isNotBlank(assetInfo.getName()), AssetInfo::getName, assetInfo.getName());
        lambda.like(StringUtils.isNotBlank(assetInfo.getBrand()), AssetInfo::getBrand, assetInfo.getBrand());
        lambda.like(StringUtils.isNotBlank(assetInfo.getModel()), AssetInfo::getModel, assetInfo.getModel());
        lambda.eq(StringUtils.isNotBlank(assetInfo.getCategoryCode()), AssetInfo::getCategoryCode, assetInfo.getCategoryCode());
        lambda.eq(ObjectUtils.isNotEmpty(assetInfo.getStatus()), AssetInfo::getStatus, assetInfo.getStatus());
        // 默认按编号排序
        lambda.orderByAsc(AssetInfo::getCode);
        return wrapper;
    }

    /**
     * 资产信息实体类转换接口
     */
    @Resource
    private AssetInfoEntityConverter assetInfoEntityConverter;

    /**
     * 资产状态日志服务
     */
    @Resource
    private AssetStatusLogService assetStatusLogService;

    /**
     * 资产信息装饰器
     */
    @Resource
    private AssetInfoDtoDecorator assetInfoDtoDecorator;

}