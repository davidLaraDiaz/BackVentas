package com.prueba.controller;

import java.util.HashMap;
import rx.Observable;
import rx.Subscription;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Cliente;
import com.prueba.service.ClienteService;
import com.prueba.service.VentaService;

@RestController
@RequestMapping()
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/")
	public HttpStatus cliente() {
		return  HttpStatus.OK ;
	}
	
	@GetMapping("rx/cliente/{id}")
	public Subscription rxGetCliente(@PathVariable Long id) {
		return Observable.just(clienteService.findById(id)).subscribe();
	}
	
	@GetMapping("rx/venta/{id}")
	public Subscription rxGetVenta(@PathVariable Long id) {
		return Observable.just(ventaService.findById(id)).subscribe();
	}
	
	
	@PostMapping("cliente/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Cliente cliente, BindingResult result) {
		
		Cliente clienNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					//se combierte a un stream
					.stream()
					//convierte a un string
					.map( err -> "El campo " + err.getField()+ " tiene el siguiente error: " + err.getDefaultMessage())
					//convirete a un list<string>
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensajes", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con exito");
		response.put("cliente", clienNew);
		
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (cliente == null) {
			response.put("mensaje", "El cliente con el ID: ".concat(id.toString()).concat("  no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
}
