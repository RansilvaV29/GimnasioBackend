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

import com.espe.gimnasio.dto.ListarRutinasDto;
import com.espe.gimnasio.dto.RutinaCrearDto;
import com.espe.gimnasio.entity.Rutina;
import com.espe.gimnasio.service.RutinaService;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

	@Autowired
    private RutinaService rutinaService;

    @PostMapping
    public ResponseEntity<?> crearRutina(@RequestBody RutinaCrearDto dto) {
        Rutina rutina = rutinaService.crearRutina(dto);
        return ResponseEntity.ok("Rutina creada con ID: " + rutina.getId());
    }
    
    @GetMapping
    public ResponseEntity<List<ListarRutinasDto>> listarRutinas() {
        List<ListarRutinasDto> rutinas = rutinaService.listarRutinasResumen();
        return ResponseEntity.ok(rutinas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RutinaCrearDto> obtenerRutina(@PathVariable Integer id) {
        return ResponseEntity.ok(rutinaService.obtenerDetalleRutina(id));
    }
    
    @GetMapping("/buscar-por-musculo/{musculoId}")
    public ResponseEntity<List<ListarRutinasDto>> buscarPorMusculo(@PathVariable Integer musculoId) {
        return ResponseEntity.ok(rutinaService.buscarRutinasPorMusculo(musculoId));
    }


}
