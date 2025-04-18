package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetStatusLogDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetStatusLogFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetStatusLogRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetStatusLogResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetStatusLogDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetStatusLogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 资产状态日志的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetStatusLogFacadeImpl implements AssetStatusLogFacade {

    /**
     * 根据资产编号查询状态变更日志
     *
     * @param assetCode 资产编号
     * @return 资产状态日志的响应对象集合
     */
    @Override
    public List<AssetStatusLogResponse> findByAssetCode(final String assetCode) {
        final List<AssetStatusLogDto> assetStatusLogDtos = assetStatusLogService.findByAssetCode(assetCode);
        return assetStatusLogDtos.stream()
                .map(assetStatusLogDtoConverter::dtoToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 根据条件分页查询资产状态日志
     *
     * @param assetStatusLogRequest 资产状态日志的请求对象
     * @return 资产状态日志的响应对象
     */
    @Override
    public PageResponse<AssetStatusLogResponse> pageByCondition(final AssetStatusLogRequest assetStatusLogRequest) {
        final AssetStatusLogDto assetStatusLogDto = assetStatusLogDtoConverter.requestToDto(assetStatusLogRequest);
        final Page<AssetStatusLogDto> assetStatusLogDtos = assetStatusLogService.pageByCondition(assetStatusLogDto);
        return assetStatusLogDtoConverter.dtoPageToResponsePage(assetStatusLogDtos);
    }

    /**
     * 资产状态日志数据传输类转换接口
     */
    @Resource
    private AssetStatusLogDtoConverter assetStatusLogDtoConverter;

    /**
     * 资产状态日志的业务处理接口
     */
    @Resource
    private AssetStatusLogService assetStatusLogService;

}