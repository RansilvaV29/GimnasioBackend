package com.notificaciones.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notificaciones.dto.NotificacionDto;
import com.notificaciones.entity.Notificacion;
import com.notificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService {

	@Autowired
	private NotificacionRepository notificacionRepository;
	
	
	public void guardarNotificacion(NotificacionDto dto) {
		Notificacion notificacion = new Notificacion();
		notificacion.setMensaje(dto.getMensaje());
		notificacion.setTipo(dto.getTipo());
		notificacion.setFecha(LocalDateTime.now());
		notificacionRepository.save(notificacion);
		

	}
	
	public List<Notificacion> obtenerTodos(){
		return notificacionRepository.findAll();
	}
}
