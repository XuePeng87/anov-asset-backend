package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetRepairDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetRepairFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetRepairRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetRepairResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetRepairDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetRepairService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 资产维修的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetRepairFacadeImpl implements AssetRepairFacade {

    /**
     * 创建资产维修记录
     *
     * @param assetRepairRequest 资产维修的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(AssetRepairRequest assetRepairRequest) {
        final AssetRepairDto assetRepairDto = assetRepairDtoConverter.requestToDto(assetRepairRequest);
        return assetRepairService.create(assetRepairDto);
    }

    /**
     * 完成维修
     *
     * @param code   维修记录编号
     * @param result 维修结果
     * @return 是否完成维修
     */
    @Override
    public boolean completeRepair(String code, String result) {
        return assetRepairService.completeRepair(code, result);
    }

    /**
     * 根据编号查询资产维修记录
     *
     * @param code 资产维修记录的编号
     * @return 资产维修记录的响应对象
     */
    @Override
    public AssetRepairResponse findByCode(String code) {
        final AssetRepairDto assetRepairDto = assetRepairService.findByCode(code);
        return assetRepairDtoConverter.dtoToResponse(assetRepairDto);
    }

    /**
     * 根据资产编号查询维修记录
     *
     * @param assetCode 资产编号
     * @return 资产维修记录的响应对象集合
     */
    @Override
    public List<AssetRepairResponse> findByAssetCode(String assetCode) {
        final List<AssetRepairDto> assetRepairDtos = assetRepairService.findByAssetCode(assetCode);
        return assetRepairDtos.stream()
                .map(assetRepairDtoConverter::dtoToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 根据条件分页查询资产维修记录
     *
     * @param assetRepairRequest 资产维修记录的请求对象
     * @return 资产维修记录的响应对象
     */
    @Override
    public PageResponse<AssetRepairResponse> pageByCondition(AssetRepairRequest assetRepairRequest) {
        final AssetRepairDto assetRepairDto = assetRepairDtoConverter.requestToDto(assetRepairRequest);
        final Page<AssetRepairDto> assetRepairDtos = assetRepairService.pageByCondition(assetRepairDto);
        return assetRepairDtoConverter.dtoPageToResponsePage(assetRepairDtos);
    }

    /**
     * 资产维修数据传输类转换接口
     */
    @Resource
    private AssetRepairDtoConverter assetRepairDtoConverter;

    /**
     * 资产维修的业务处理接口
     */
    @Resource
    private AssetRepairService assetRepairService;

}