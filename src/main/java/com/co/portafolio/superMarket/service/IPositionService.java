package com.co.portafolio.superMarket.service;

import com.co.portafolio.superMarket.dto.PositionDto;

import java.util.List;


public interface IPositionService {
    List<PositionDto> findAll();
    PositionDto findById(Integer positionId);
    PositionDto findByPosition(String position);
    void createPosition(PositionDto positionDto) throws Exception;
}
