package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetLoanDto;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetLoan;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产借用实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetLoanEntityConverter
        extends EntityConverter<AssetLoanDto, AssetLoan> {
}