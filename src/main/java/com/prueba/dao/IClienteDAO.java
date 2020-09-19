package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{

}
