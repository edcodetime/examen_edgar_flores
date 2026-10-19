package com.example.examen.service.impl;

import com.example.examen.entity.Orden;
import com.example.examen.entity.Producto;
import com.example.examen.entity.Sucursal;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.ProductoRepositoy;
import com.example.examen.repository.SucursalRepository;
import com.example.examen.service.OrdenService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;
    private final ProductoRepositoy productoRepositoy;
    private final SucursalRepository sucursalRepository;

    public OrdenServiceImpl(OrdenRepository ordenRepository, ProductoRepositoy productoRepositoy, SucursalRepository sucursalRepository) {
        this.ordenRepository = ordenRepository;
        this.productoRepositoy = productoRepositoy;
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public void realizaOrden(Orden orden) {

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(orden.getSucursal().getNombre());

        Sucursal sucursalNueva = sucursalRepository.save(sucursal);
        List<Producto> productos = productoRepositoy.saveAll(orden.getProductos());

        Orden ordenNueva = new Orden();
        ordenNueva.setSucursal(sucursalNueva);
        ordenNueva.setProductos(productos);
        float total = (float)productos.stream().mapToDouble(Producto::getPrecio).sum();
        ordenNueva.setTotal(total);
        ordenNueva.setFecha(new Date());
        ordenRepository.save(ordenNueva);


    }

    @Override
    public Orden getOrden(Integer id) {
        return ordenRepository.findById(id).orElse(null);
    }
}
