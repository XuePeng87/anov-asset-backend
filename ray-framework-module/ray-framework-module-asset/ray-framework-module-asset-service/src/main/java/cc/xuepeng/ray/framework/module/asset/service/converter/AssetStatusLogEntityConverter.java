package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetStatusLog;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产状态变更记录实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetStatusLogEntityConverter
        extends EntityConverter<AssetStatusLogDto, AssetStatusLog> {
}