package com.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prueba.dao.IDetalleVentaDAO;
import com.prueba.model.DetalleVenta;

@Service
public class DetalleService implements IDetalleImplements{

	@Autowired
	private IDetalleVentaDAO data;
	
	@Override
	public List<DetalleVenta> findAll() {
		// TODO Auto-generated method stub
		return data.findAll();

	}

	@Override
	public Page<DetalleVenta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return data.findAll(pageable);
	}

	@Override
	public DetalleVenta findById(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public DetalleVenta save(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		return data.save(detalle);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}
	
}
