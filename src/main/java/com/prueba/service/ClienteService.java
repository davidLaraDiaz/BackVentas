package com.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.dao.IClienteDAO;
import com.prueba.model.Cliente;

@Service
public class ClienteService implements ICLienteImplements{

	@Autowired
	private IClienteDAO data;
	
	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return data.save(cliente);
	}

}
