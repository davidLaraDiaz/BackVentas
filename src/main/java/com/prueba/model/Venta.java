package com.prueba.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta")
public class Venta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private int idVenta;
	
	@Column(name = "idCliente")
	@ManyToOne
    @JoinColumn(name = "idCliente")
	private Cliente idCliente;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
	private List<DetalleVenta> detalles;
	
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}


	public int getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}


	public Cliente getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public List<DetalleVenta> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}


	
	
	
	
	
	
	
}
