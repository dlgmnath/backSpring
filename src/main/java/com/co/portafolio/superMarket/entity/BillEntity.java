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
@Table(name = "BILL")
public class BillEntity {

    @Id
    @Column(name = "BILL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @Column(name = "BILLCODE")
    private Integer billCode;

    @Column(name = "EMPLOY_ID")
    private Integer employId;

    @Column(name = "PRODUCTS")
    private String product;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "DATE")
    private String date;

    @Column(name = "STATUS")
    private Integer status;
}
