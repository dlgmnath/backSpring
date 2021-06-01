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
@Table(name = "EMPLOY")
public class EmployEntity {

    @Id
    @Column(name = "EMPLOY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employId;

    @Column(name = "PERSONAL_ID")
    private String personalId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POSITION_ID")
    private String positionId;

    @Column(name = "STATUS")
    private Integer status;

}
