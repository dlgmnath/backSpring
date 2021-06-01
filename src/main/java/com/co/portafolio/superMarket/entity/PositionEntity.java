package com.co.portafolio.superMarket.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Position")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionEntity {
    @Id
    @Column(name = "POSITION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(name = "POSITION")
    private String position;
}
