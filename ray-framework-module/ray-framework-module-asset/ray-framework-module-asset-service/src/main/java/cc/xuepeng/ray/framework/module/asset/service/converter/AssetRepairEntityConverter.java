package cc.xuepeng.ray.framework.module.asset.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.asset.repository.entity.AssetRepair;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetRepairDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 资产维修实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetRepairEntityConverter
        extends EntityConverter<AssetRepairDto, AssetRepair> {
}