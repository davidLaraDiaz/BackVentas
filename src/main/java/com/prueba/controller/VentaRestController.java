package com.prueba.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.prueba.model.Venta;
import com.prueba.service.VentaService;


@RestController
@RequestMapping
public class VentaRestController {

	
	@Autowired
	private VentaService ventaServ;
		
	

	@GetMapping("/venta")
	public ResponseEntity<?> showAll() {
		List<Venta> ventas = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			ventas = ventaServ.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (ventas.size() == 0 ) {
			response.put("mensaje", "No hay ventas en la DB ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
	}
	
	@GetMapping("/venta/page/{page}")
	public Page<Venta> index(@PathVariable Integer page){	
		Pageable pageable = PageRequest.of(page,15);
		return ventaServ.findAll( pageable );
	}
	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Venta venta = null;

		Map<String, Object> response = new HashMap<>();
		
		try {
			venta = ventaServ.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (venta == null) {
			response.put("mensaje", "El venta con el ID: ".concat(id.toString()).concat("  no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	
	
	@PostMapping("/venta/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Venta venta, BindingResult result) {
		
		Venta clienNew = null;
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
			
				clienNew = ventaServ.save(venta);
			
			
		} catch (DataAccessException e) {
			response.put("mensajes", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La venta ha sido creada con exito");
		response.put("venta", clienNew);
		
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

	
	
	
	
}
