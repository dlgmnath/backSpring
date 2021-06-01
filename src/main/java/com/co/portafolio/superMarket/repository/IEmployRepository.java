package com.co.portafolio.superMarket.repository;

import com.co.portafolio.superMarket.entity.EmployEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployRepository extends JpaRepository<EmployEntity,Integer> {
    List<EmployEntity> findAll();
    Optional<EmployEntity> findById(Integer employId);
    Optional<EmployEntity> findByName(String name);

}
