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
import com.prueba.model.Venta;
import com.prueba.service.VentaService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = VentaRestController.class)
public class VentaRestTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private VentaService service;

	@Test
	@WithMockUser(roles = "ADMIN")
	void testShowAll() throws Exception {
		String url = "/venta/";

		mockMvc.perform(get(url).contentType("application/json")).andExpect(status().is(404));

		System.out.println("No hay ventas en la BD");
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testShow() throws Exception {
		String url = "/venta/2";

		mockMvc.perform(get(url).contentType("application/json")).andExpect(status().is(404));

		System.out.println("El venta con id 2 no existe");
	}


	@Test
	@WithMockUser(roles = "ADMIN")
	void testCreate() throws Exception {
		String url = "/venta/new";
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente((long)2);
		cliente.setNombre("David");
		cliente.setApellido("Lara");
		cliente.setDni("1234");
		cliente.setEmail("david@mail");
		cliente.setTelefono("321321");

		Venta venta = new Venta();
		venta.setIdVenta((long) 0);
		venta.setFecha(null);
		venta.setIdCliente(cliente);

		mockMvc.perform(post(url)
				.content(objectMapper.writeValueAsString(venta))
				.contentType("application/json"))
				.andExpect(status().isOk());

		
	}

}
