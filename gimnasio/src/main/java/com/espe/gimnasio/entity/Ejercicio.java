package com.espe.gimnasio.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ejercicio")
	private Integer idEjercicio;

	@Column(name="link_explicacion")
	private String linkExplicacion;

	@Column(name="nombre_ejercicio")
	private String nombreEjercicio;

	@Column(name="nro_repeticiones")
	private Integer nroRepeticiones;

	@Column(name="nro_series")
	private Integer nroSeries;

	//bi-directional many-to-one association to Musculo
	@ManyToOne
	@JoinColumn(name="id_musuculo")
	private Musculo musculo;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="ejercicio")
	private List<Rutina> rutinas;

	public Ejercicio() {
	}

	public Integer getIdEjercicio() {
		return this.idEjercicio;
	}

	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getLinkExplicacion() {
		return this.linkExplicacion;
	}

	public void setLinkExplicacion(String linkExplicacion) {
		this.linkExplicacion = linkExplicacion;
	}

	public String getNombreEjercicio() {
		return this.nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	public Integer getNroRepeticiones() {
		return this.nroRepeticiones;
	}

	public void setNroRepeticiones(Integer nroRepeticiones) {
		this.nroRepeticiones = nroRepeticiones;
	}

	public Integer getNroSeries() {
		return this.nroSeries;
	}

	public void setNroSeries(Integer nroSeries) {
		this.nroSeries = nroSeries;
	}

	public Musculo getMusculo() {
		return this.musculo;
	}

	public void setMusculo(Musculo musculo) {
		this.musculo = musculo;
	}

	public List<Rutina> getRutinas() {
		return this.rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public Rutina addRutina(Rutina rutina) {
		getRutinas().add(rutina);
		rutina.setEjercicio(this);

		return rutina;
	}

	public Rutina removeRutina(Rutina rutina) {
		getRutinas().remove(rutina);
		rutina.setEjercicio(null);

		return rutina;
	}

}