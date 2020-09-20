package com.prueba.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
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

@Entity
@Table(name = "venta")
public class Venta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private Long idVenta;
	
	@JoinColumn(name = "idCliente")
	@ManyToOne( cascade = CascadeType.ALL )
	private Cliente idCliente;
	
	@Column(name = "fecha")
	private Date fecha;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
	private List<DetalleVenta> detalles;
	
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}

	

	public Long getIdVenta() {
		return idVenta;
	}



	public void setIdVenta(Long idVenta) {
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


	public void addDetalle(DetalleVenta detalle) {
		List<DetalleVenta> midetalle = this.getDetalles();
		if (midetalle == null) {
			midetalle = new ArrayList<>();
		}
		midetalle.add(detalle);
	}
	
	public void deleteDetalle(DetalleVenta detalle) {
		List<DetalleVenta> midetalle = this.getDetalles();
		if(midetalle != null) {
			for (DetalleVenta detalleVenta : midetalle) {
				if (detalleVenta.getIdDetalle() == detalle.getIdDetalle()) {
					midetalle.remove(detalleVenta);
				}
			}
		}
	}
	
	public List<DetalleVenta> getDetalles() {
		return detalles;
	}






	
	
	
	
	
	
	
	
	
}
