package com.EcoMarketFullStack.EcoMarket.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @Column(nullable = false)
    private  BigDecimal costo;

    @Column (nullable = true)
    private String comentario;

    @ManyToOne
    @JoinColumn (name = "id_usuario",nullable = false )
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "envio_id")
    private Envio envio;
}
