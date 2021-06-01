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
public class ProductDto implements Serializable {
    private Integer productId;
    private Integer barCode;
    private String name;
    private Float price;
    private Integer status;
}
