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

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idDetalleVenta")
	private int idDetalle;
	
	@Column(name = "idVenta")
	@ManyToOne
    @JoinColumn(name = "idVenta")
	private Venta idVenta;
	
	@Column(name = "idProducto")
	@ManyToOne
    @JoinColumn(name = "idProducto")
	private int idProducto;
	
	
	
	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}



	public int getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}



	public Venta getIdVenta() {
		return idVenta;
	}



	public void setIdVenta(Venta idVenta) {
		this.idVenta = idVenta;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	
	
	
}
