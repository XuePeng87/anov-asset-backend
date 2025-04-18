package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetScrapDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetScrapFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetScrapRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetScrapResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetScrapDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetScrapService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 资产报废的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetScrapFacadeImpl implements AssetScrapFacade {

    /**
     * 创建资产报废记录
     *
     * @param assetScrapRequest 资产报废的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(AssetScrapRequest assetScrapRequest) {
        final AssetScrapDto assetScrapDto = assetScrapDtoConverter.requestToDto(assetScrapRequest);
        return assetScrapService.create(assetScrapDto);
    }

    /**
     * 取消报废
     *
     * @param code   报废记录编号
     * @param remark 备注
     * @return 是否取消报废成功
     */
    @Override
    public boolean cancelScrap(String code, String remark) {
        return assetScrapService.cancelScrap(code, remark);
    }

    /**
     * 根据编号查询资产报废记录
     *
     * @param code 资产报废记录的编号
     * @return 资产报废记录的响应对象
     */
    @Override
    public AssetScrapResponse findByCode(String code) {
        final AssetScrapDto assetScrapDto = assetScrapService.findByCode(code);
        return assetScrapDtoConverter.dtoToResponse(assetScrapDto);
    }

    /**
     * 根据资产编号查询报废记录
     *
     * @param assetCode 资产编号
     * @return 资产报废记录的响应对象集合
     */
    @Override
    public List<AssetScrapResponse> findByAssetCode(String assetCode) {
        final List<AssetScrapDto> assetScrapDtos = assetScrapService.findByAssetCode(assetCode);
        return assetScrapDtos.stream()
                .map(assetScrapDtoConverter::dtoToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 根据条件分页查询资产报废记录
     *
     * @param assetScrapRequest 资产报废记录的请求对象
     * @return 资产报废记录的响应对象
     */
    @Override
    public PageResponse<AssetScrapResponse> pageByCondition(AssetScrapRequest assetScrapRequest) {
        final AssetScrapDto assetScrapDto = assetScrapDtoConverter.requestToDto(assetScrapRequest);
        final Page<AssetScrapDto> assetScrapDtos = assetScrapService.pageByCondition(assetScrapDto);
        return assetScrapDtoConverter.dtoPageToResponsePage(assetScrapDtos);
    }

    /**
     * 资产报废数据传输类转换接口
     */
    @Resource
    private AssetScrapDtoConverter assetScrapDtoConverter;

    /**
     * 资产报废的业务处理接口
     */
    @Resource
    private AssetScrapService assetScrapService;

}