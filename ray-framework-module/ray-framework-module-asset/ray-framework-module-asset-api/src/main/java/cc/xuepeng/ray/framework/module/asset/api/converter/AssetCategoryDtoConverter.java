package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetCategoryRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetCategoryResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产分类数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetCategoryDtoConverter
        extends DtoConverter<AssetCategoryRequest, AssetCategoryDto, AssetCategoryResponse> {

}