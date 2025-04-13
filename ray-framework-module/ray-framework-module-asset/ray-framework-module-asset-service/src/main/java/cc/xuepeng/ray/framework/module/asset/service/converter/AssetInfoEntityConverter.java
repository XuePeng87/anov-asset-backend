package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetInfo;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产信息实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetInfoEntityConverter
        extends EntityConverter<AssetInfoDto, AssetInfo> {
}