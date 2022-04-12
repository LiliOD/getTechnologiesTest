package com.GetTechnologies.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	
	
	private Long id;
	private Date fecha;
	private int monto;

	//Getters & setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public Factura(Long id, Date fecha, int monto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
	}//constructor
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}//toString
	
	

	
}//class Factura
