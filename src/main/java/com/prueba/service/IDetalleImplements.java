package com.prueba.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.model.DetalleVenta;


public interface IDetalleImplements {

	public List<DetalleVenta> findAll();
	
	public Page<DetalleVenta> findAll( Pageable pageable);
	
	public DetalleVenta findById(Long id);
	
	public DetalleVenta save(DetalleVenta DetalleVenta);
	
	public void delete(Long id);
	
}
