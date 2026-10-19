package com.example.examen.service;

import com.example.examen.entity.Orden;
import com.example.examen.entity.Producto;
import com.example.examen.repository.OrdenRepository;

import java.util.List;

public interface OrdenService {

    void realizaOrden(Orden orden);
    Orden getOrden(Integer id);
}
