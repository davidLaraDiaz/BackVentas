package com.prueba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "detalleventa")
public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idDetalle")
	private Long idDetalle;
	
	@Column(name = "idVenta")
	@ManyToOne
    @JoinColumn(name = "idVenta")
	private Venta idVenta;
	
	@Column(name = "idProducto")
	@ManyToOne
    @JoinColumn(name = "idProducto")
	private Producto idProducto;
	
	
	
	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}





	public Long getIdDetalle() {
		return idDetalle;
	}







	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}







	public Venta getIdVenta() {
		return idVenta;
	}



	public void setIdVenta(Venta idVenta) {
		this.idVenta = idVenta;
	}





	public Producto getIdProducto() {
		return idProducto;
	}





	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}




	
	
	
}
