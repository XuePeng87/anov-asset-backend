package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetScrap;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetScrapDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产报废实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetScrapEntityConverter
        extends EntityConverter<AssetScrapDto, AssetScrap> {
}