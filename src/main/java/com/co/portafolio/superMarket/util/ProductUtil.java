package com.co.portafolio.superMarket.util;

import com.co.portafolio.superMarket.dto.ProductDto;
import com.co.portafolio.superMarket.entity.ProductEntity;

public class ProductUtil {

    public static ProductDto ProductEntityToProductDto(ProductEntity productEntity){
        return ProductDto.builder()
                .productId((productEntity.getProductId()))
                .barCode(productEntity.getBarCode())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .status(productEntity.getStatus())
                .build();
    }

    public  static ProductEntity ProductDtoToProductEntity(ProductDto productDto){
        return ProductEntity.builder()
                .productId(productDto.getProductId())
                .barCode(productDto.getBarCode())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .status(productDto.getStatus())
                .build();
    }
}
