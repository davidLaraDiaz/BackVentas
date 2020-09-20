package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.DetalleVenta;

@Repository
public interface IDetalleVentaDAO extends JpaRepository<DetalleVenta, Long>{

}
