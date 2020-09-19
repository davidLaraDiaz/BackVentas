package com.prueba.service;


import com.prueba.model.Cliente;



public interface ICLienteImplements {


	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	

	
}
