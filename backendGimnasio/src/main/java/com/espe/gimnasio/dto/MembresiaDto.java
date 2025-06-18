package com.espe.gimnasio.dto;

import java.math.BigDecimal;

public class MembresiaDto {
	private String descripcion;
	private String nombreMembresia;
	private BigDecimal precio;
	private String vigencia;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombreMembresia() {
		return nombreMembresia;
	}
	public void setNombreMembresia(String nombreMembresia) {
		this.nombreMembresia = nombreMembresia;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	
}
