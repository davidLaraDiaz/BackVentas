package com.prueba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.model.Cliente;
import com.prueba.service.ClienteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteRestController.class)
public class ClienteRestTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private ClienteService service;
  
  
  @Test
  void noAccessReturns403() throws Exception {
    mockMvc.perform(get("/")
    	    .contentType("application/json"))
    	    .andExpect(status().is(403));
  }
  
  @Test
  @WithMockUser(roles = "ADMIN")
  void accessOK() throws Exception {
	String url ="/";
	
    mockMvc.perform(get(url)
    	    .contentType("application/json"))
    	    .andExpect(status().isOk());
  }
  
  @Test
  @WithMockUser(roles = "ADMIN")
  void addCliente() throws Exception {
	String url ="/cliente/new";
	
	Cliente cliente = new Cliente();
	cliente.setIdCliente((long)2);
	cliente.setNombre("David");
	cliente.setApellido("Lara");
	cliente.setDni("1234");
	cliente.setEmail("david@mail");
	cliente.setTelefono("321321");
	
    mockMvc.perform(post(url)
    		.content(objectMapper.writeValueAsString(cliente))
    	    .contentType("application/json"))
    	    .andExpect(status().isOk());
  }
  
  
  @Test
  @WithMockUser(roles = "ADMIN")
  void fingCliente() throws Exception {
	String url ="/cliente/1";
		
    mockMvc.perform(get(url)
    	    .contentType("application/json"))
    	    .andExpect(status().is(404));
    
    System.out.println("El id 1 No exite");
    
    
  }
  
  

}

