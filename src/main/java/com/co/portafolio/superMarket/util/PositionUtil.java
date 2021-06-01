package com.co.portafolio.superMarket.util;

import com.co.portafolio.superMarket.dto.PositionDto;
import com.co.portafolio.superMarket.entity.PositionEntity;

public class PositionUtil {
    public static PositionDto PositionEntityToPositionDto(PositionEntity positionEntity){
        return PositionDto.builder()
                .positionId(positionEntity.getPositionId())
                .position(positionEntity.getPosition())
                .build();
    }

    public static PositionEntity PositionDtoToPositionEntity(PositionDto positionDto){
        return PositionEntity.builder()
                .positionId(positionDto.getPositionId())
                .position(positionDto.getPosition())
                .build();
    }
}
