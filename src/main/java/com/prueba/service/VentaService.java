package com.prueba.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prueba.dao.IDetalleVentaDAO;
import com.prueba.dao.IVentaDAO;
import com.prueba.model.DetalleVenta;
import com.prueba.model.Venta;


@Service
public class VentaService implements IVentaImplemets{

	@Autowired
	private IVentaDAO data;
	
	@Autowired
	private IDetalleVentaDAO dataDetalle;
	
	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public Page<Venta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return data.findAll(pageable);
	}

	@Override
	public Venta findById(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Venta save(Venta venta) {
		return data.save(venta);
	}

	@Override
	public boolean addDetalle(Long id, DetalleVenta detalle) {
		
		Venta miventa= data.findById(id).orElse(null);
		
		if (miventa == null) {
			return false;
		}
		
		dataDetalle.save(detalle);
		
		return true;
		
	}

	@Override
	public boolean deleteDetalle(Long id, DetalleVenta detalle) {
		Venta miventa= data.findById(id).orElse(null);
		
		if (miventa == null) {
			return false;
		}
		
		try {
			miventa.deleteDetalle(detalle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}





	
	
}
