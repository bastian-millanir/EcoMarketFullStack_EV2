package com.EcoMarketFullStack.EcoMarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sku;

    @Column(unique=true, length = 100, nullable=false)
    private String nombre_producto;

    @Column(unique=true, length=200, nullable=false)
    private String precio;

    @Column(unique=true, length=100, nullable=false)
    private Integer stock;

    @OneToMany
    @JoinColumn(name = "sku", nullable = false, unique = true)
    private Pedido id_pedido;  // PREGUNTAR SI CREARON LA CLASE ITEM_PEDIDO, PREGUNTAR EL NOMBRE COLUMNA ID DEL PEDIDO



}
