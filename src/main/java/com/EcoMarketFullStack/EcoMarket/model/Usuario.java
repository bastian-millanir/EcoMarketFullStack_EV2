package com.EcoMarketFullStack.EcoMarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

}
