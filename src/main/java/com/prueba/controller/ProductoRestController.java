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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Producto;
import com.prueba.service.ProductoService;

@RestController
@RequestMapping
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	
	@PostMapping("producto/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Producto producto, BindingResult result) {
		
		Producto producNew = null;
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
			producNew = productoService.save(producto);
		} catch (DataAccessException e) {
			response.put("mensajes", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido creado con exito");
		response.put("produto", producNew);
		
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/producto")
	public ResponseEntity<?> showAll() {
		List<Producto> productos = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			productos = productoService.findAll();
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (productos.size() == 0 ) {
			response.put("mensaje", "No hay productos en la DB ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Producto producto = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			producto = productoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Hay un problema con la base de datos: ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (producto == null) {
			response.put("mensaje", "El producto con el ID: ".concat(id.toString()).concat("  no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			productoService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el producto en la  base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El producto ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?>  update( @RequestBody Producto producto, BindingResult result, @PathVariable Long id) {
		
		Producto productoActual = productoService.findById(id);
		Producto productoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
	//manejo de errores de los campos
	if (result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					//se combierte a un stream
					.stream()
					//convierte a un string
					.map( err -> "El campo " + err.getField()+ " tiene el siguiente error: " + err.getDefaultMessage())
					//convirete a un list<string>
					.collect(Collectors.toList());
			
			response.put("mensaje", "Error en la base de datos");
			response.put("Errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (productoActual == null) {
			response.put("mensaje", "Error no se puede editar el producto con el ID: ".concat(id.toString()).concat(" por que no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			productoActual.setNombre(producto.getNombre());
			productoActual.setPrecio(producto.getPrecio());
			productoUpdate = productoService.save(productoActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la  base de datos");
			response.put("errors", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El producto ha sido actualizado con exito");
		response.put("producto", productoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	
}
