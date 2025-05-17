package com.EcoMarketFullStack.EcoMarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="userId")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserId {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length=13, nullable=false)
    private String name;
}
