package com.espe.gimnasio.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the rutina database table.
 * 
 */
@Entity
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rutina")
	private Integer idRutina;

	@Column(name="nombre_rutina")
	private String nombreRutina;

	private String observaciones;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="id_ejercicio")
	private Ejercicio ejercicio;

	public Rutina() {
	}

	public Integer getIdRutina() {
		return this.idRutina;
	}

	public void setIdRutina(Integer idRutina) {
		this.idRutina = idRutina;
	}

	public String getNombreRutina() {
		return this.nombreRutina;
	}

	public void setNombreRutina(String nombreRutina) {
		this.nombreRutina = nombreRutina;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

}