package com.prueba.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.prueba.model.Producto;
import com.prueba.service.ProductoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductoRestController.class)
class ProductoRestTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ProductoService service;

	@Test
	@WithMockUser(roles = "ADMIN")
	void testCreate() throws Exception {
		String url = "/producto/new";

		Producto producto = new Producto();
		producto.setIdProducto((long) 0);
		producto.setNombre("Carro");
		producto.setPrecio("123456");

		mockMvc.perform(post(url).content(objectMapper.writeValueAsString(producto)).contentType("application/json"))
				.andExpect(status().isOk());

		mockMvc.perform(post(url).content(objectMapper.writeValueAsString(producto)).contentType("application/json"))
				.andExpect(status().isOk());

		mockMvc.perform(post(url).content(objectMapper.writeValueAsString(producto)).contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testShowAll() throws Exception {
		String url = "/producto/";

		mockMvc.perform(get(url).contentType("application/json")).andExpect(status().is(404));

		System.out.println("No hay Productos en la BD");
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testShow() throws Exception {
		String url = "/producto/2";

		mockMvc.perform(get(url).contentType("application/json")).andExpect(status().is(404));

		System.out.println("El producto con id 2 no existe");
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testDelete() throws Exception {
		String url = "/producto/1";

		mockMvc.perform(delete(url).contentType("application/json")).andExpect(status().isOk());

		System.out.println("Se ha eliminado el producto");
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void testUpdate() throws Exception {
		String url = "/producto/1";

		Producto producto = new Producto();
		producto.setIdProducto((long) 0);
		producto.setNombre("Carro");
		producto.setPrecio("123456");

		mockMvc.perform(put(url).content(objectMapper.writeValueAsString(producto)).contentType("application/json"))
				.andExpect(status().is(404));
		System.out.println("El usuario no existe, para editarlo");
	}

}
