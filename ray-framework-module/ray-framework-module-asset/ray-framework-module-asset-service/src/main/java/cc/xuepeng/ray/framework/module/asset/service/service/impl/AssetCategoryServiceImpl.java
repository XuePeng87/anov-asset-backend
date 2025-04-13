package cc.xuepeng.ray.framework.module.asset.service.service.impl;

import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetCategory;
import cc.xuepeng.ray.framework.module.asset.repository.repository.AssetCategoryRepository;
import cc.xuepeng.ray.framework.module.asset.service.converter.AssetCategoryEntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetCategoryDuplicateException;
import cc.xuepeng.ray.framework.module.asset.service.exception.AssetCategoryNotFoundException;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetCategoryService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.sdk.auth.annotation.ModifyUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 资产分类的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class AssetCategoryServiceImpl
        extends ServiceImpl<AssetCategoryRepository, AssetCategory>
        implements AssetCategoryService {

    /**
     * 创建资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final AssetCategoryDto assetCategoryDto) {
        final String name = assetCategoryDto.getName();
        if (this.checkNameExisted(StringUtils.EMPTY, name)) {
            throw new AssetCategoryDuplicateException("资产分类名称[" + name + "]已存在");
        }
        assetCategoryDto.setCode(RandomUtil.get32UUID());
        final AssetCategory assetCategory = assetCategoryEntityConverter.dtoToEntity(assetCategoryDto);
        return super.save(assetCategory);
    }

    /**
     * 修改资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final AssetCategoryDto assetCategoryDto) {
        final String code = assetCategoryDto.getCode();
        final String name = assetCategoryDto.getName();
        if (this.checkNameExisted(code, name)) {
            throw new AssetCategoryDuplicateException("资产分类名称[" + name + "]已存在");
        }
        final AssetCategory assetCategory = assetCategoryEntityConverter.dtoToEntity(assetCategoryDto);
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper(code);
        return super.update(assetCategory, wrapper);
    }

    /**
     * 根据编号删除资产分类
     *
     * @param codes 资产分类的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByCodes(final List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return Boolean.TRUE;
        }
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper();
        wrapper.lambda().in(AssetCategory::getCode, codes);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询资产分类
     *
     * @param code 资产分类的编号
     * @return 资产分类的数据传输对象
     */
    @Override
    public AssetCategoryDto findByCode(final String code) {
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper(code);
        final AssetCategory assetCategory = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(assetCategory)) {
            throw new AssetCategoryNotFoundException("无法根据编号[" + code + "]查询到资产分类");
        }
        return assetCategoryEntityConverter.entityToDto(assetCategory);
    }

    /**
     * 根据条件分页查询资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 资产分类的数据传输对象集合
     */
    @Override
    public Page<AssetCategoryDto> pageByCondition(final AssetCategoryDto assetCategoryDto) {
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper(assetCategoryDto);
        final Page<AssetCategory> page = PageUtil.createPage(assetCategoryDto);
        final Page<AssetCategory> assetCategories = super.page(page, wrapper);
        return assetCategoryEntityConverter.entityPageToDtoPage(assetCategories);
    }

    /**
     * 查询所有资产分类
     *
     * @return 资产分类的数据传输对象集合
     */
    @Override
    public List<AssetCategoryDto> findAll() {
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper();
        wrapper.lambda().orderByAsc(AssetCategory::getSequence);
        final List<AssetCategory> assetCategories = super.list(wrapper);
        return assetCategoryEntityConverter.entityListToDtoList(assetCategories);
    }

    /**
     * 检测资产分类名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 资产分类名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper();
        final List<AssetCategory> assetCategories = super.list(wrapper.lambda().eq(AssetCategory::getName, name));
        return ExistsUtil.exists(
                assetCategories,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<AssetCategory> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 资产分类的编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<AssetCategory> createQueryWrapper(final String code) {
        final QueryWrapper<AssetCategory> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<AssetCategory> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), AssetCategory::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<AssetCategory> createQueryWrapper(final AssetCategoryDto assetCategoryDto) {
        final QueryWrapper<AssetCategory> wrapper = QueryWrapperUtil.createQueryWrapper(assetCategoryDto);
        final AssetCategory assetCategory = assetCategoryEntityConverter.dtoToEntity(assetCategoryDto);
        final LambdaQueryWrapper<AssetCategory> lambda = wrapper.lambda();
        lambda.like(StringUtils.isNotBlank(assetCategory.getName()), AssetCategory::getName, assetCategory.getName());
        lambda.orderByAsc(AssetCategory::getSequence);
        return wrapper;
    }

    /**
     * 资产分类实体类转换接口
     */
    @Resource
    private AssetCategoryEntityConverter assetCategoryEntityConverter;

}