package com.co.portafolio.superMarket.service.impl;

import com.co.portafolio.superMarket.dto.PositionDto;
import com.co.portafolio.superMarket.entity.PositionEntity;
import com.co.portafolio.superMarket.repository.IPositionRepository;
import com.co.portafolio.superMarket.service.IPositionService;
import com.co.portafolio.superMarket.util.PositionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<PositionDto> findAll(){
        List<PositionEntity> positionEntityList = iPositionRepository.findAll();
        List<PositionDto> positionDtoList = new ArrayList();

        for(PositionEntity entity: positionEntityList) {
            positionDtoList.add(PositionUtil.PositionEntityToPositionDto(entity));
        }
        return positionDtoList;
    }

    @Override
    public PositionDto findById(Integer positionId) {
        Optional<PositionEntity> entity = iPositionRepository.findById(positionId);
        PositionDto positionDto = null;

        if(entity.isPresent()){
            positionDto = PositionUtil.PositionEntityToPositionDto(entity.get());
        }
        return positionDto;
    }

    @Override
    public PositionDto findByPosition(String position){
        Optional<PositionEntity> positionEntity = iPositionRepository.findByPosition(position);
        PositionDto positionDto = null;

        if(positionEntity.isPresent()){
            positionDto = PositionUtil.PositionEntityToPositionDto(positionEntity.get());
        }
        return positionDto;
    }

    @Override
    public void createPosition(PositionDto positionDto) throws Exception{
        Optional<PositionEntity> positionEntity = iPositionRepository.findByPosition(positionDto.getPosition());
        if(!positionEntity.isPresent()){
            iPositionRepository.save(PositionUtil.PositionDtoToPositionEntity(positionDto));
        } else {
            throw new Exception("El cargo ya existe");
        }
    }


}
