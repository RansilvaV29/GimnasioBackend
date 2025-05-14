package com.espe.gimnasio.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the musculo database table.
 * 
 */
@Entity
@NamedQuery(name="Musculo.findAll", query="SELECT m FROM Musculo m")
public class Musculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_musuculo")
	private Integer idMusuculo;

	@Column(name="nombre_musculo")
	private String nombreMusculo;

	//bi-directional many-to-one association to Ejercicio
	@OneToMany(mappedBy="musculo")
	private List<Ejercicio> ejercicios;

	public Musculo() {
	}

	public Integer getIdMusuculo() {
		return this.idMusuculo;
	}

	public void setIdMusuculo(Integer idMusuculo) {
		this.idMusuculo = idMusuculo;
	}

	public String getNombreMusculo() {
		return this.nombreMusculo;
	}

	public void setNombreMusculo(String nombreMusculo) {
		this.nombreMusculo = nombreMusculo;
	}

	public List<Ejercicio> getEjercicios() {
		return this.ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public Ejercicio addEjercicio(Ejercicio ejercicio) {
		getEjercicios().add(ejercicio);
		ejercicio.setMusculo(this);

		return ejercicio;
	}

	public Ejercicio removeEjercicio(Ejercicio ejercicio) {
		getEjercicios().remove(ejercicio);
		ejercicio.setMusculo(null);

		return ejercicio;
	}

}