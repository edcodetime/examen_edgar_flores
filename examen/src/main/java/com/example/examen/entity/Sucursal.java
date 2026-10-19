package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sucursalId;

    private String nombre;

    @OneToMany
    private List<Orden> ordenes;
}
