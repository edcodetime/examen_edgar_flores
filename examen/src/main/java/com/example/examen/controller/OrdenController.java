package com.example.examen.controller;

import com.example.examen.entity.Orden;
import com.example.examen.entity.Producto;
import com.example.examen.service.OrdenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("/saveOrden")
    public void saveOrden(@RequestBody Orden orden) {
        ordenService.realizaOrden(orden);
    }

    @GetMapping("/getOrden/{id}")
    public Orden getOrden(@PathVariable Integer id) {
        return ordenService.getOrden(id);
    }
}
