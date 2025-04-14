package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetInfoRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetInfoResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产信息数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetInfoDtoConverter
        extends DtoConverter<AssetInfoRequest, AssetInfoDto, AssetInfoResponse> {

}