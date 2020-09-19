package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{

}
