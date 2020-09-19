package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.Venta;

@Repository
public interface IVentaDAO extends JpaRepository<Venta, Long>{

}
