package com.notificaciones.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.notificaciones.dto.NotificacionDto;
import com.notificaciones.service.NotificacionService;

@Component
public class NotificacionListener {
	
	@Autowired
	private NotificacionService notificacionService;
	
	@Autowired
	private ObjectMapper mapped;
	
	@RabbitListener(queues = "notificaciones.cola")
	public void recibirNotificacion(String mensajeJson) {
		try {
			NotificacionDto dto = mapped.readValue(mensajeJson, NotificacionDto.class);
			notificacionService.guardarNotificacion(dto);
			System.out.println("Notificacion recibida y guardada " + dto.getMensaje());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
