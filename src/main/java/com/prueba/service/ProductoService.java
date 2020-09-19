package com.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prueba.dao.IProductoDAO;
import com.prueba.model.Producto;

@Service
public class ProductoService implements IProductoImplements {

	@Autowired
	private IProductoDAO data;
	
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return data.findAll();

	}

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return data.findAll(pageable);
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return data.save(producto);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}

}
