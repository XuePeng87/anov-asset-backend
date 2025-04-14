package cc.xuepeng.ray.framework.module.asset.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetLoanRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetLoanResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetLoanDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产借用数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetLoanDtoConverter
        extends DtoConverter<AssetLoanRequest, AssetLoanDto, AssetLoanResponse> {

}