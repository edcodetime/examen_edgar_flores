package com.example.examen.repository;

import com.example.examen.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoy extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.codigo = ?1")
    Producto findByCodigo(String codigo);

}
