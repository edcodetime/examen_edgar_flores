package com.example.examen.controller;

import com.example.examen.entity.Producto;
import com.example.examen.service.ProductoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductoController {


    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PutMapping("/actualizaPrecio")
    public void actualizaPrecio(@RequestBody Producto producto) {
        productoService.actualizaPrecioProducto(producto);
    }
}
