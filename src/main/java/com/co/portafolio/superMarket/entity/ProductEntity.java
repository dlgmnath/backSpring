package com.co.portafolio.superMarket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "ID_PRODUCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "BARCODE")
    private Integer barCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "STATUS")
    private Integer status;
}
