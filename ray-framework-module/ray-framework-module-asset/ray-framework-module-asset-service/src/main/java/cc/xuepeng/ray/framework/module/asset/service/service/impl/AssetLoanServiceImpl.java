package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetLoan;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetLoanStatus;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetLoanRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetLoanEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetLoanDto;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetCannotLoanException;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetInfoService;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetLoanService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
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
 * 资产借用的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetLoanServiceImpl
        extends ServiceImpl<AssetLoanRepository, AssetLoan>
        implements AssetLoanService {

    /**
     * 创建资产借用记录
     *
     * @param assetLoanDto 资产借用的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    @Transactional(rollbackFor = Exception.class)
    public boolean loanAsset(final AssetLoanDto assetLoanDto) {
        // 检查资产状态是否为在库
        AssetInfoDto assetInfoDto = assetInfoService.findByCode(assetLoanDto.getAssetCode());
        if (assetInfoDto.getStatus() != AssetStatus.IN_STOCK) {
            throw new AssetCannotLoanException("只有在库状态的资产才能借用");
        }
        // 设置初始状态为借用中
        assetLoanDto.setCode(RandomUtil.get32UUID());
        assetLoanDto.setLoanDate(LocalDate.now());
        assetLoanDto.setStatus(AssetLoanStatus.LOANED);
        final AssetLoan assetLoan = assetLoanEntityConverter.dtoToEntity(assetLoanDto);
        // 更新资产状态为借用中
        assetInfoService.updateStatus(
                assetLoanDto.getAssetCode(),
                assetLoanDto.getUserCode(),
                AssetStatus.IN_USE,
                "资产借用");
        return super.save(assetLoan);
    }

    /**
     * 归还资产
     *
     * @param assetLoanDto 资产借用的数据传输对象
     * @return 是否归还成功
     */
    @Override
    @CreateUser
    @Transactional(rollbackFor = Exception.class)
    public boolean returnAsset(final AssetLoanDto assetLoanDto) {
        // 检查资产状态是否为在库
        AssetInfoDto assetInfoDto = assetInfoService.findByCode(assetLoanDto.getAssetCode());
        if (assetInfoDto.getStatus() != AssetStatus.IN_USE) {
            throw new AssetCannotLoanException("只有使用状态的资产才能归还");
        }
        // 设置初始状态为借用中
        assetLoanDto.setCode(RandomUtil.get32UUID());
        assetLoanDto.setLoanDate(LocalDate.now());
        assetLoanDto.setStatus(AssetLoanStatus.LOANED);
        final AssetLoan assetLoan = assetLoanEntityConverter.dtoToEntity(assetLoanDto);
        // 更新资产状态为借用中
        assetInfoService.updateStatus(assetLoanDto.getAssetCode(), StringUtils.EMPTY, AssetStatus.IN_STOCK, "资产归还");
        return super.save(assetLoan);
    }

    /**
     * 根据资产编号查询借用记录
     *
     * @param assetCode 资产编号
     * @return 资产借用记录的数据传输对象集合
     */
    @Override
    public List<AssetLoanDto> findByAssetCode(final String assetCode) {
        final QueryWrapper<AssetLoan> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(AssetLoan::getAssetCode, assetCode);
        final List<AssetLoan> assetLoans = super.list(wrapper);
        return assetLoanEntityConverter.entityListToDtoList(assetLoans);
    }

    /**
     * 根据条件分页查询资产借用记录
     *
     * @param assetLoanDto 资产借用记录的数据传输对象
     * @return 资产借用记录的数据传输对象集合
     */
    @Override
    public Page<AssetLoanDto> pageByCondition(final AssetLoanDto assetLoanDto) {
        final QueryWrapper<AssetLoan> wrapper = this.createQueryWrapper(assetLoanDto);
        final Page<AssetLoan> page = PageUtil.createPage(assetLoanDto);
        final Page<AssetLoan> assetLoans = super.page(page, wrapper);
        return assetLoanEntityConverter.entityPageToDtoPage(assetLoans);
    }

    /**
     * 创建QueryWrapper
     *
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetLoan> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建QueryWrapper
     *
     * @param assetLoanDto 资产借用记录的数据传输对象
     * @return QueryWrapper对象
     */
    private QueryWrapper<AssetLoan> createQueryWrapper(final AssetLoanDto assetLoanDto) {
        final QueryWrapper<AssetLoan> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<AssetLoan> lambda = wrapper.lambda();
        // 根据编号模糊查询
        if (StringUtils.isNotEmpty(assetLoanDto.getCode())) {
            lambda.eq(AssetLoan::getCode, assetLoanDto.getCode());
        }
        // 根据借用人模糊查询
        if (StringUtils.isNotEmpty(assetLoanDto.getUserCode())) {
            lambda.eq(AssetLoan::getUserCode, assetLoanDto.getUserCode());
        }
        // 根据状态精确查询
        if (!ObjectUtils.isEmpty(assetLoanDto.getStatus())) {
            lambda.eq(AssetLoan::getStatus, assetLoanDto.getStatus());
        }
        // 排序
        lambda.orderByDesc(AssetLoan::getCreateTime);
        return wrapper;
    }

    /**
     * 资产借用记录实体转换器
     */
    @Resource
    private AssetLoanEntityConverter assetLoanEntityConverter;

    /**
     * 资产信息服务接口
     */
    @Resource
    private AssetInfoService assetInfoService;

}