package com.co.portafolio.superMarket.util;

import com.co.portafolio.superMarket.dto.BillDto;
import com.co.portafolio.superMarket.entity.BillEntity;

public class BillUtil {
    public static BillDto BillEntityToBillDto(BillEntity billEntity){
        return BillDto.builder()
                .billId(billEntity.getBillId())
                .billCode(billEntity.getBillCode())
                .employId(billEntity.getEmployId())
                .product(billEntity.getProduct())
                .price(billEntity.getPrice())
                .date(billEntity.getDate())
                .build();
    }

    public  static BillEntity BillDtoToBillEntity(BillDto billDto){
        return BillEntity.builder()
                .billId(billDto.getBillId())
                .billCode(billDto.getBillCode())
                .employId(billDto.getEmployId())
                .product(billDto.getProduct())
                .price(billDto.getPrice())
                .date(billDto.getDate())
                .build();
    }
}
