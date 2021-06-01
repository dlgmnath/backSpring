package com.co.portafolio.superMarket.service.impl;

import com.co.portafolio.superMarket.dto.ProductDto;
import com.co.portafolio.superMarket.entity.ProductEntity;
import com.co.portafolio.superMarket.repository.IProductRepository;
import com.co.portafolio.superMarket.util.ProductUtil;
import com.co.portafolio.superMarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<ProductDto> findAll(){
        List<ProductEntity> productEntityList = iProductRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList();

        for(ProductEntity entity: productEntityList) {
            productDtoList.add(ProductUtil.ProductEntityToProductDto(entity));
        }
        return productDtoList;
    }

    @Override
    public ProductDto findById( Integer productId) {
        Optional<ProductEntity> entity = iProductRepository.findById(productId);
        ProductDto productDto = null;

        if(entity.isPresent()){
            productDto = ProductUtil.ProductEntityToProductDto(entity.get());
        }
        return productDto;
    }

    @Override
    public ProductDto findByBarCode(Integer barCode){
        Optional<ProductEntity> entity = iProductRepository.findByBarCode((barCode));
        ProductDto productDto = null;

        if(entity.isPresent()){
            productDto = ProductUtil.ProductEntityToProductDto((entity.get()));
        }
        return productDto;
    }

    @Override
    public void createProduct(ProductDto productDto) throws Exception {
        Optional<ProductEntity> entity = iProductRepository.findByBarCode(productDto.getBarCode());
        if(!entity.isPresent()){
            iProductRepository.save(ProductUtil.ProductDtoToProductEntity(productDto));
        } else {
            throw new Exception("Producto ya existe");
        }
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) throws Exception {
        Optional<ProductEntity> productEntity = iProductRepository.findById(productId);

        if(productEntity.isPresent()) {
            productEntity.get().setBarCode(productDto.getBarCode());
            productEntity.get().setName(productDto.getName());
            productEntity.get().setPrice(productDto.getPrice());
            productEntity.get().setStatus(productDto.getStatus());
            iProductRepository.save(productEntity.get());
            return productDto;
        } else {
            throw new Exception("Producto no encontrado");
        }
    }

    @Override
    public void deleteProduct (Integer productId) throws Exception {
        Optional<ProductEntity> productEntity = iProductRepository.findById((productId));

        if(productEntity.isPresent()){
            productEntity.get().setStatus(0);
            iProductRepository.save(productEntity.get());
        }else {
            throw new Exception(" No es posible eliminar el producto");
        }
    }
}
