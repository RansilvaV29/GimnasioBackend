package com.espe.gimnasio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.gimnasio.dto.MembresiaDto;
import com.espe.gimnasio.entity.Membresia;
import com.espe.gimnasio.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {
	@Autowired
	private MembresiaService membresiaService;
	
	@PostMapping
	public ResponseEntity<Membresia> crearMembresia(@RequestBody MembresiaDto dto){
		Membresia nueva = membresiaService.registrar(dto);
		return new ResponseEntity<>(nueva, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Membresia> editar(@PathVariable Integer id, @RequestBody MembresiaDto membresiaDto) {
        Membresia membresiaActualizada = membresiaService.editarMembresia(id, membresiaDto);
        return ResponseEntity.ok(membresiaActualizada);
    }
}
