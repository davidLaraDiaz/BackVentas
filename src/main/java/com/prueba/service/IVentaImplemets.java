package com.prueba.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.model.DetalleVenta;
import com.prueba.model.Venta;


public interface IVentaImplemets {

	
	public List<Venta> findAll();
	
	public Page<Venta> findAll( Pageable pageable);
	
	public Venta findById(Long id);
	
	public Venta save(Venta venta);
	
	public boolean addDetalle(Long id, DetalleVenta detalle);
	
	public boolean deleteDetalle(Long id, DetalleVenta detalle);
	
}
