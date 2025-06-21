package com.notificaciones.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificaciones.dto.NotificacionDto;
import com.notificaciones.entity.Notificacion;
import com.notificaciones.service.NotificacionService;

@Controller
@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
	@Autowired
    private NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<String> crearNotificacion(@RequestBody NotificacionDto dto) {
        try {
            notificacionService.guardarNotificacion(dto);
            return ResponseEntity.ok("Notificación guardada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar la notificación");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Notificacion>> obtenerTodas() {
        List<Notificacion> notificaciones = notificacionService.obtenerTodos();
        return ResponseEntity.ok(notificaciones);
    }
}
