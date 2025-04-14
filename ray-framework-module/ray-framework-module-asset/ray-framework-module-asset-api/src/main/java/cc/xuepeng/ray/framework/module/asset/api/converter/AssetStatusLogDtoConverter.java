package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetStatusLogResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产状态变更记录数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetStatusLogDtoConverter
        extends DtoConverter<Void, AssetStatusLogDto, AssetStatusLogResponse> {

}