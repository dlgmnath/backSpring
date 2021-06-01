package com.co.portafolio.superMarket.repository;

import com.co.portafolio.superMarket.entity.PositionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPositionRepository extends JpaRepository<PositionEntity, Integer> {
    List<PositionEntity> findAll();
    Optional<PositionEntity> findById(Integer positionId);
    Optional<PositionEntity> findByPosition(String position);
}
