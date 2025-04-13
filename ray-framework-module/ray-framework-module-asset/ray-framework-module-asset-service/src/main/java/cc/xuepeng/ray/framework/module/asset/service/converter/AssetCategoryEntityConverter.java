package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetCategory;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产分类实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetCategoryEntityConverter
        extends EntityConverter<AssetCategoryDto, AssetCategory> {
}