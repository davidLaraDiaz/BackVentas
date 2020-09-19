package com.prueba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private int idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private String precio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
	private List<DetalleVenta> detalles;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public List<DetalleVenta> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	
	
}
