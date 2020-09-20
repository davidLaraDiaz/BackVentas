package com.prueba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.DetalleVenta;
import com.prueba.service.DetalleService;

@RestController
@RequestMapping
public class DetalleRestController {

	
	@Autowired
	private DetalleService detalleService;
	
	
	@PostMapping("detalle/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody DetalleVenta detalleVenta, BindingResult result) {
		
		DetalleVenta producNew = null;
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
			producNew = detalleService.save(detalleVenta);
		} catch (DataAccessException e) {
			response.put("mensajes", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Detalle de la Venta ha sido creado con exito");
		response.put("destalle", producNew);
		
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/detalle")
	public ResponseEntity<?> showAll() {
		List<DetalleVenta> detalleVentas = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			detalleVentas = detalleService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (detalleVentas.size() == 0 ) {
			response.put("mensaje", "No hay Detalles de Ventas en la DB ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<DetalleVenta>>(detalleVentas, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		DetalleVenta DetalleVenta = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			DetalleVenta = detalleService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (DetalleVenta == null) {
			response.put("mensaje", "El Detalle de Venta con el ID: ".concat(id.toString()).concat("  no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DetalleVenta>(DetalleVenta, HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
