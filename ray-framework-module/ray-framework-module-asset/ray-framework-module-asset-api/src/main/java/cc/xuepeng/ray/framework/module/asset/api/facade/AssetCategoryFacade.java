package cc.xuepeng.ray.framework.module.asset.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetCategoryRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetCategoryResponse;

import java.util.List;

/**
 * 资产类别的业务处理门面接口
 *
 * @author xuepeng
 */
public interface AssetCategoryFacade {

    /**
     * 创建资产类别
     *
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 是否创建成功
     */
    boolean create(final AssetCategoryRequest assetCategoryRequest);

    /**
     * 修改资产类别
     *
     * @param code 类别编号
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final AssetCategoryRequest assetCategoryRequest);

    /**
     * 根据编号删除资产分类
     *
     * @param codes 资产分类的编号集合
     * @return 是否删除成功
     */
    boolean deleteByCodes(final List<String> codes);

    /**
     * 根据编号查询资产类别
     *
     * @param code 资产类别的编号
     * @return 资产类别的响应对象
     */
    AssetCategoryResponse findByCode(final String code);

    /**
     * 根据条件分页查询资产类别
     *
     * @param assetCategoryRequest 资产类别的请求对象
     * @return 资产类别的响应对象
     */
    PageResponse<AssetCategoryResponse> pageByCondition(final AssetCategoryRequest assetCategoryRequest);

    /**
     * 查询所有资产分类
     *
     * @return 资产分类的响应对象集合
     */
    List<AssetCategoryResponse> findAll();

}