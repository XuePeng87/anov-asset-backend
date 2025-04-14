package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetRepairRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetRepairResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetRepairDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产维修数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetRepairDtoConverter
        extends DtoConverter<AssetRepairRequest, AssetRepairDto, AssetRepairResponse> {

}