package com.co.portafolio.superMarket.repository;

import com.co.portafolio.superMarket.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Integer productId);
    Optional<ProductEntity> findByBarCode(Integer codeBar);
}
