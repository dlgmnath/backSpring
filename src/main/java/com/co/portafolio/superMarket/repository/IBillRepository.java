package com.co.portafolio.superMarket.repository;

import com.co.portafolio.superMarket.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBillRepository extends JpaRepository<BillEntity, Integer>{
    List<BillEntity> findAll();
    Optional<BillEntity> findById(Integer billId);
    Optional<BillEntity> findByBillCode(Integer code);
}
