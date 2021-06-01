package com.co.portafolio.superMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillDto implements Serializable{
    private Integer billId;
    private Integer billCode;
    private Integer employId;
    private String product;
    private Integer price;
    private String date;
    private Integer Status;
}
