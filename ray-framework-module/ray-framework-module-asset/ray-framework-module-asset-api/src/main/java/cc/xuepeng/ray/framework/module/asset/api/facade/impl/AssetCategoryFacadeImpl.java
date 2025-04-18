package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetCategoryDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetCategoryFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetCategoryRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetCategoryResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetCategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资产分类的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetCategoryFacadeImpl implements AssetCategoryFacade {

    /**
     * 创建资产分类
     *
     * @param assetCategoryRequest 资产分类的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final AssetCategoryRequest assetCategoryRequest) {
        final AssetCategoryDto assetCategoryDto = assetCategoryDtoConverter.requestToDto(assetCategoryRequest);
        return assetCategoryService.create(assetCategoryDto);
    }

    /**
     * 修改资产分类
     *
     * @param code                 分类编号
     * @param assetCategoryRequest 资产分类的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final AssetCategoryRequest assetCategoryRequest) {
        final AssetCategoryDto assetCategoryDto = assetCategoryDtoConverter.requestToDto(assetCategoryRequest);
        assetCategoryDto.setCode(code);
        return assetCategoryService.update(assetCategoryDto);
    }

    /**
     * 根据编号删除资产分类
     *
     * @param codes 资产分类的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByCodes(final List<String> codes) {
        return assetCategoryService.deleteByCodes(codes);
    }

    /**
     * 根据编号查询资产分类
     *
     * @param code 资产分类的编号
     * @return 资产分类的响应对象
     */
    @Override
    public AssetCategoryResponse findByCode(final String code) {
        final AssetCategoryDto assetCategoryDto = assetCategoryService.findByCode(code);
        return assetCategoryDtoConverter.dtoToResponse(assetCategoryDto);
    }

    /**
     * 根据条件分页查询资产分类
     *
     * @param assetCategoryRequest 资产分类的请求对象
     * @return 资产分类的响应对象
     */
    @Override
    public PageResponse<AssetCategoryResponse> pageByCondition(final AssetCategoryRequest assetCategoryRequest) {
        final AssetCategoryDto assetCategoryDto = assetCategoryDtoConverter.requestToDto(assetCategoryRequest);
        final Page<AssetCategoryDto> assetCategoryDtos = assetCategoryService.pageByCondition(assetCategoryDto);
        return assetCategoryDtoConverter.dtoPageToResponsePage(assetCategoryDtos);
    }

    /**
     * 查询所有资产分类
     *
     * @return 资产分类的响应对象集合
     */
    @Override
    public List<AssetCategoryResponse> findAll() {
        final List<AssetCategoryDto> assetCategoryDtos = assetCategoryService.findAll();
        return assetCategoryDtoConverter.dtoListToResponseList(assetCategoryDtos);
    }

    /**
     * 资产分类数据传输类转换接口
     */
    @Resource
    private AssetCategoryDtoConverter assetCategoryDtoConverter;

    /**
     * 资产分类的业务处理接口
     */
    @Resource
    private AssetCategoryService assetCategoryService;

}