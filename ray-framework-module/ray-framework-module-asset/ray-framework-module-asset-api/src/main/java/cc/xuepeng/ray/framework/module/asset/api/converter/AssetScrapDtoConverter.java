package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetScrapRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetScrapResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetScrapDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产报废数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetScrapDtoConverter
        extends DtoConverter<AssetScrapRequest, AssetScrapDto, AssetScrapResponse> {

}