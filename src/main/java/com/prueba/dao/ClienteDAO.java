package com.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
