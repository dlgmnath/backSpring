package com.co.portafolio.superMarket.service;

import com.co.portafolio.superMarket.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();
    ProductDto findById(Integer productId);
    ProductDto findByBarCode(Integer barCode);
    void createProduct(ProductDto productDto) throws Exception;
    ProductDto updateProduct(Integer productId, ProductDto productDto) throws Exception;
    void deleteProduct(Integer productId) throws Exception;
}
