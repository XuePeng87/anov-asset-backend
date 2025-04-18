package cc.xuepeng.ray.framework.module.asset.service.decorator;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetCategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 资产信息装饰器
 *
 * @author xuepeng
 */
@Component
public class AssetInfoDtoDecorator {

    @Resource
    private AssetCategoryService assetCategoryService;

    /**
     * 装饰单个AssetInfoDto
     *
     * @param dto 待装饰的dto
     * @return 装饰后的dto
     */
    public AssetInfoDto decorate(AssetInfoDto dto) {
        if (dto == null) return null;
        Map<String, String> categoryMap = assetCategoryService.findAllToMap();
        dto.setCategoryName(categoryMap.get(dto.getCategoryCode()));
        return dto;
    }

    /**
     * 装饰AssetInfoDto分页对象
     *
     * @param page 待装饰的分页对象
     * @return 装饰后的分页对象
     */
    public Page<AssetInfoDto> decorate(Page<AssetInfoDto> page) {
        if (page == null || page.getRecords() == null) return page;
        Map<String, String> categoryMap = assetCategoryService.findAllToMap();
        List<AssetInfoDto> records = page.getRecords();
        records.forEach(dto -> dto.setCategoryName(categoryMap.get(dto.getCategoryCode())));
        return page;
    }

}