package com.EcoMarketFullStack.EcoMarket.model;

import java.sql.Time;
import java.util.Date;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pedido")

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private Date fecha_pedido;

    @Column(nullable=false)
    private Time hora_pedido;

    @Column
}
