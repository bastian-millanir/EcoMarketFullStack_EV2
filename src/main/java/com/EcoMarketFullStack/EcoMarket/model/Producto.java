package com.EcoMarketFullStack.EcoMarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name="producto") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 100, nullable=false)
    private String nombre_producto;

    @Column(unique=true, length=200, nullable=false)
    private Double precio;

    @Column(unique=false, length=100, nullable=false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "pedido", nullable = false, unique = true)
    private Pedido pedido;  



}
