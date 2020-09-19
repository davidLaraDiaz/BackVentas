package com.prueba.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.model.Producto;



public interface IProductoImplements {

	public List<Producto> findAll();
	
	public Page<Producto> findAll( Pageable pageable);
	
	public Producto findById(Long id);
	
	public Producto save(Producto Producto);
	
	public void delete(Long id);
	
}
