package com.co.portafolio.superMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployDto implements Serializable {
    private Integer employId;
    private String personalId;
    private String name;
    private String positionId;
    private Integer status;
}
