package com.EcoMarketFullStack.EcoMarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length=13, nullable=false)
    private String run;

    @Column(nullable=false)
    private String nombres;

    @Column(nullable=false)
    private String apellidos;

    @Column(nullable=true)
    private String fechaNacimiento;

    @Column(nullable=false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private UserId userId;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Pedido> pedidos;

}
