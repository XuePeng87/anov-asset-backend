package cc.xuepeng.ray.framework.module.asset.service.decorator;

import cc.xuepeng.ray.framework.module.asset.service.dto.AssetCategoryDto;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetCategoryService;
import cc.xuepeng.ray.framework.module.system.service.dto.SysUserDto;
import cc.xuepeng.ray.framework.module.system.service.service.SysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 资产信息装饰器
 *
 * @author xuepeng
 */
@Component
public class AssetInfoDtoDecorator {

    @Resource
    private AssetCategoryService assetCategoryService;

    @Resource
    private SysUserService sysUserService;

    /**
     * 装饰AssetInfoDto分页对象
     *
     * @param page 待装饰的分页对象
     * @return 装饰后的分页对象
     */
    public Page<AssetInfoDto> decorateCategory(Page<AssetInfoDto> page) {
        if (page == null || page.getRecords() == null) return page;
        Map<String, String> categoryMap = assetCategoryService.findAllToMap();
        List<AssetInfoDto> records = page.getRecords();
        records.forEach(dto -> dto.setCategoryName(categoryMap.get(dto.getCategoryCode())));
        return page;
    }

    public Page<AssetInfoDto> decorateUser(Page<AssetInfoDto> page) {
        if (page == null || page.getRecords() == null) return page;
        final List<SysUserDto> sysUserDtos = sysUserService.listByCondition(new SysUserDto());
        final Map<String, String> userNameMap = sysUserDtos.stream()
                .collect(Collectors.toMap(
                        SysUserDto::getCode,
                        SysUserDto::getName,
                        (existing, replacement) -> existing));
        List<AssetInfoDto> records = page.getRecords();
        records.forEach(dto -> dto.setUserName(userNameMap.get(dto.getUserCode())));
        return page;
    }

}