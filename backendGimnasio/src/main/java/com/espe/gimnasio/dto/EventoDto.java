// EventoDTO.java
package com.espe.gimnasio.dto;

import java.util.Date;

public class EventoDto {

    private String nombreEvento;
    private String descripcion;
    private Integer cupoMaximo;
    private Date fecha;
    private String horaInicio;
    private String horraFin;

    // Getters y setters
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorraFin() {
        return horraFin;
    }

    public void setHorraFin(String horraFin) {
        this.horraFin = horraFin;
    }
}
