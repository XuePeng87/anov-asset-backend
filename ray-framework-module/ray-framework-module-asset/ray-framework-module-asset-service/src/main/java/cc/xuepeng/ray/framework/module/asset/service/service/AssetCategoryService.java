package cc.xuepeng.ray.framework.module.asset.service.service;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 资产分类的业务处理接口
 *
 * @author xuepeng
 */
public interface AssetCategoryService {

    /**
     * 创建资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final AssetCategoryDto assetCategoryDto);

    /**
     * 修改资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final AssetCategoryDto assetCategoryDto);

    /**
     * 根据编号删除资产分类
     *
     * @param codes 资产分类的编号集合
     * @return 是否删除成功
     */
    boolean deleteByCodes(final List<String> codes);

    /**
     * 根据编号查询资产分类
     *
     * @param code 资产分类的编号
     * @return 资产分类的数据传输对象
     */
    AssetCategoryDto findByCode(final String code);

    /**
     * 根据条件分页查询资产分类
     *
     * @param assetCategoryDto 资产分类的数据传输对象
     * @return 资产分类的数据传输对象集合
     */
    Page<AssetCategoryDto> pageByCondition(final AssetCategoryDto assetCategoryDto);

    /**
     * 查询所有资产分类
     *
     * @return 资产分类的数据传输对象集合
     */
    List<AssetCategoryDto> findAll();
}