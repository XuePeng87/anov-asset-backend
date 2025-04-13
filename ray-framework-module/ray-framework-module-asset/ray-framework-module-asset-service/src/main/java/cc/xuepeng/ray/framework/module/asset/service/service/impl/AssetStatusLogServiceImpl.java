package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetStatusLog;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetStatusLogRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetStatusLogEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetStatusLogService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 资产状态日志的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetStatusLogServiceImpl
        extends ServiceImpl<AssetStatusLogRepository, AssetStatusLog>
        implements AssetStatusLogService {

    /**
     * 创建资产状态变更日志
     *
     * @param assetCode  资产编号
     * @param statusFrom 原状态
     * @param statusTo   新状态
     * @param remark     备注
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean createLog(final String assetCode, final AssetStatus statusFrom, final AssetStatus statusTo, final String remark) {
        AssetStatusLogDto assetStatusLogDto = new AssetStatusLogDto();
        assetStatusLogDto.setAssetCode(assetCode);
        assetStatusLogDto.setStatusFrom(statusFrom);
        assetStatusLogDto.setStatusTo(statusTo);
        assetStatusLogDto.setRemark(remark);
        assetStatusLogDto.setDeleted(false);
        assetStatusLogDto.setCreateTime(LocalDateTime.now());
        return create(assetStatusLogDto);
    }

    /**
     * 创建资产状态变更日志
     *
     * @param assetStatusLogDto 资产状态日志的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final AssetStatusLogDto assetStatusLogDto) {
        final AssetStatusLog assetStatusLog = assetStatusLogEntityConverter.dtoToEntity(assetStatusLogDto);
        return super.save(assetStatusLog);
    }

    /**
     * 根据资产编号查询状态变更日志
     *
     * @param assetCode 资产编号
     * @return 资产状态日志的数据传输对象集合
     */
    @Override
    public List<AssetStatusLogDto> findByAssetCode(final String assetCode) {
        final QueryWrapper<AssetStatusLog> wrapper = this.createQueryWrapper();
        wrapper.lambda()
                .eq(AssetStatusLog::getAssetCode, assetCode)
                .orderByDesc(AssetStatusLog::getCreateTime);
        final List<AssetStatusLog> assetStatusLogs = super.list(wrapper);
        return assetStatusLogEntityConverter.entityListToDtoList(assetStatusLogs);
    }

    /**
     * 根据条件分页查询资产状态日志
     *
     * @param assetStatusLogDto 资产状态日志的数据传输对象
     * @return 资产状态日志的数据传输对象集合
     */
    @Override
    public Page<AssetStatusLogDto> pageByCondition(final AssetStatusLogDto assetStatusLogDto) {
        final QueryWrapper<AssetStatusLog> wrapper = this.createQueryWrapper(assetStatusLogDto);
        final Page<AssetStatusLog> page = PageUtil.createPage(assetStatusLogDto);
        final Page<AssetStatusLog> assetStatusLogs = super.page(page, wrapper);
        return assetStatusLogEntityConverter.entityPageToDtoPage(assetStatusLogs);
    }

    /**
     * 根据ID删除状态变更日志
     *
     * @param ids 资产状态日志的ID集合
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Boolean.TRUE;
        }
        return super.removeByIds(ids);
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<AssetStatusLog> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param assetStatusLogDto 资产状态日志的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<AssetStatusLog> createQueryWrapper(final AssetStatusLogDto assetStatusLogDto) {
        final QueryWrapper<AssetStatusLog> wrapper = QueryWrapperUtil.createQueryWrapper();
        final AssetStatusLog assetStatusLog = assetStatusLogEntityConverter.dtoToEntity(assetStatusLogDto);
        final LambdaQueryWrapper<AssetStatusLog> lambda = wrapper.lambda();
        // 增加条件查询
        lambda.eq(StringUtils.isNotBlank(assetStatusLog.getAssetCode()),
                AssetStatusLog::getAssetCode, assetStatusLog.getAssetCode());
        // 查询状态变更范围
        lambda.eq(assetStatusLog.getStatusFrom() != null,
                AssetStatusLog::getStatusFrom, assetStatusLog.getStatusFrom());
        lambda.eq(assetStatusLog.getStatusTo() != null,
                AssetStatusLog::getStatusTo, assetStatusLog.getStatusTo());
        // 默认按创建时间倒序排序
        lambda.orderByDesc(AssetStatusLog::getCreateTime);
        return wrapper;
    }

    /**
     * 资产状态日志实体类转换接口
     */
    @Resource
    private AssetStatusLogEntityConverter assetStatusLogEntityConverter;

}