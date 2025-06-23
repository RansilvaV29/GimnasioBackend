package com.espe.gimnasio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.gimnasio.dto.CupoEventoDto;
import com.espe.gimnasio.dto.EventoDto;
import com.espe.gimnasio.entity.Evento;
import com.espe.gimnasio.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	@Autowired
    private EventoService eventoService;
	
	@GetMapping
    public List<EventoDto> getTodosEventos() {
        return eventoService.obtenerTodosEventos();
    }

	@PostMapping
    public ResponseEntity<?> crearEvento(@RequestBody EventoDto dto) {
        try {
            Evento evento = eventoService.crearEvento(dto);
            return ResponseEntity.ok(evento);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage()); // Devuelve 400 con mensaje de error
        }
    }
	
	@PostMapping("/{idEvento}/agregar-usuario/{idUsuario}")
    public ResponseEntity<Evento> agregarUsuario(@PathVariable Integer idEvento, @PathVariable Integer idUsuario) {
        Evento eventoActualizado = eventoService.agregarUsuarioAEvento(idEvento, idUsuario);
        return ResponseEntity.ok(eventoActualizado);
    }
	
	@GetMapping("/{idEvento}/cupos")
    public CupoEventoDto getCupos(@PathVariable Integer idEvento) {
        return eventoService.obtenerCupoActual(idEvento);
    }
}
