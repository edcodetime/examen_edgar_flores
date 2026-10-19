package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    private String codigo;
    private String descripcion;
    private Float precio;
}
