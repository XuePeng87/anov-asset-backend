package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetInfoDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetInfoFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetInfoRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetInfoResponse;
import cc.xuepeng.ray.framework.module.asset.repository.enums.AssetStatus;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetInfoDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 资产信息的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetInfoFacadeImpl implements AssetInfoFacade {

    /**
     * 创建资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final AssetInfoRequest assetInfoRequest) {
        final AssetInfoDto assetInfoDto = assetInfoDtoConverter.requestToDto(assetInfoRequest);
        return assetInfoService.create(assetInfoDto);
    }

    /**
     * 修改资产信息
     *
     * @param code 资产编号
     * @param assetInfoRequest 资产信息的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final AssetInfoRequest assetInfoRequest) {
        final AssetInfoDto assetInfoDto = assetInfoDtoConverter.requestToDto(assetInfoRequest);
        assetInfoDto.setCode(code);
        return assetInfoService.update(assetInfoDto);
    }

    /**
     * 根据编号查询资产信息
     *
     * @param code 资产信息的编号
     * @return 资产信息的响应对象
     */
    @Override
    public AssetInfoResponse findByCode(final String code) {
        final AssetInfoDto assetInfoDto = assetInfoService.findByCode(code);
        return assetInfoDtoConverter.dtoToResponse(assetInfoDto);
    }

    /**
     * 根据条件分页查询资产信息
     *
     * @param assetInfoRequest 资产信息的请求对象
     * @return 资产信息的响应对象
     */
    @Override
    public PageResponse<AssetInfoResponse> pageByCondition(final AssetInfoRequest assetInfoRequest) {
        final AssetInfoDto assetInfoDto = assetInfoDtoConverter.requestToDto(assetInfoRequest);
        final Page<AssetInfoDto> assetInfoDtos = assetInfoService.pageByCondition(assetInfoDto);
        return assetInfoDtoConverter.dtoPageToResponsePage(assetInfoDtos);
    }

    /**
     * 资产信息数据传输类转换接口
     */
    @Resource
    private AssetInfoDtoConverter assetInfoDtoConverter;

    /**
     * 资产信息的业务处理接口
     */
    @Resource
    private AssetInfoService assetInfoService;

}