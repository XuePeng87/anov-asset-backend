package cc.xuepeng.ray.framework.module.asset.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.asset.api.converter.AssetLoanDtoConverter;
import cc.xuepeng.ray.framework.module.asset.api.facade.AssetLoanFacade;
import cc.xuepeng.ray.framework.module.asset.api.request.AssetLoanRequest;
import cc.xuepeng.ray.framework.module.asset.api.response.AssetLoanResponse;
import cc.xuepeng.ray.framework.module.asset.service.dto.AssetLoanDto;
import cc.xuepeng.ray.framework.module.asset.service.service.AssetLoanService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 资产借用的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class AssetLoanFacadeImpl implements AssetLoanFacade {

    /**
     * 创建资产借用记录
     *
     * @param assetLoanRequest 资产借用的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean loanAsset(AssetLoanRequest assetLoanRequest) {
        final AssetLoanDto assetLoanDto = assetLoanDtoConverter.requestToDto(assetLoanRequest);
        return assetLoanService.loanAsset(assetLoanDto);
    }

    /**
     * 归还资产
     *
     * @param assetLoanRequest 资产归还的请求对象
     * @return 是否归还成功
     */
    @Override
    public boolean returnAsset(AssetLoanRequest assetLoanRequest) {
        final AssetLoanDto assetLoanDto = assetLoanDtoConverter.requestToDto(assetLoanRequest);
        return assetLoanService.returnAsset(assetLoanDto);
    }

    /**
     * 根据资产编号查询借用记录
     *
     * @param assetCode 资产编号
     * @return 资产借用记录的响应对象集合
     */
    @Override
    public List<AssetLoanResponse> findByAssetCode(String assetCode) {
        final List<AssetLoanDto> assetLoanDtos = assetLoanService.findByAssetCode(assetCode);
        return assetLoanDtos.stream()
                .map(assetLoanDtoConverter::dtoToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 根据条件分页查询资产借用记录
     *
     * @param assetLoanRequest 资产借用记录的请求对象
     * @return 资产借用记录的响应对象
     */
    @Override
    public PageResponse<AssetLoanResponse> pageByCondition(AssetLoanRequest assetLoanRequest) {
        final AssetLoanDto assetLoanDto = assetLoanDtoConverter.requestToDto(assetLoanRequest);
        final Page<AssetLoanDto> assetLoanDtos = assetLoanService.pageByCondition(assetLoanDto);
        return assetLoanDtoConverter.dtoPageToResponsePage(assetLoanDtos);
    }

    /**
     * 资产借用数据传输类转换接口
     */
    @Resource
    private AssetLoanDtoConverter assetLoanDtoConverter;

    /**
     * 资产借用的业务处理接口
     */
    @Resource
    private AssetLoanService assetLoanService;

}