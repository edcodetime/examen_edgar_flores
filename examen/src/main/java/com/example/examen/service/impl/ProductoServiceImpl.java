package com.example.examen.service.impl;

import com.example.examen.entity.Producto;
import com.example.examen.repository.ProductoRepositoy;
import com.example.examen.service.ProductoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepositoy productoRepositoy;

    public ProductoServiceImpl(ProductoRepositoy productoRepositoy) {
        this.productoRepositoy = productoRepositoy;
    }

    @Override
    public void actualizaPrecioProducto(Producto producto) {
        Producto productoNuevo = productoRepositoy.findByCodigo(producto.getCodigo());
        productoNuevo.setPrecio(producto.getPrecio());
        productoRepositoy.save(productoNuevo);
    }
}
