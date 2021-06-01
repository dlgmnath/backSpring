package com.co.portafolio.superMarket.util;

import com.co.portafolio.superMarket.dto.EmployDto;
import com.co.portafolio.superMarket.entity.EmployEntity;

public class EmployUtil {
    public static EmployDto EmployEntityToEmployDto(EmployEntity employEntity){
        return EmployDto.builder()
                .employId(employEntity.getEmployId())
                .personalId(employEntity.getPersonalId())
                .name(employEntity.getName())
                .positionId(employEntity.getPositionId())
                .status(employEntity.getStatus())
                .build();
    }

    public static EmployEntity EmployDtoToEmployEntity(EmployDto employDto){
        return EmployEntity.builder()
                .employId(employDto.getEmployId())
                .personalId(employDto.getPersonalId())
                .name(employDto.getName())
                .positionId(employDto.getPositionId())
                .status(employDto.getStatus())
                .build();
    }
}
