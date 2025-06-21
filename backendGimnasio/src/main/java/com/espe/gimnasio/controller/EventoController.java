package com.espe.gimnasio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.gimnasio.dto.EventoDto;
import com.espe.gimnasio.entity.Evento;
import com.espe.gimnasio.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	@Autowired
    private EventoService eventoService;

	@PostMapping
    public ResponseEntity<?> crearEvento(@RequestBody EventoDto dto) {
        try {
            Evento evento = eventoService.crearEvento(dto);
            return ResponseEntity.ok(evento);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage()); // Devuelve 400 con mensaje de error
        }
    }
}
