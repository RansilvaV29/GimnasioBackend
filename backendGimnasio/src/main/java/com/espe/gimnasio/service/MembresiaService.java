package com.espe.gimnasio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espe.gimnasio.dto.MembresiaDto;
import com.espe.gimnasio.entity.Membresia;
import com.espe.gimnasio.repository.MembresiaRepository;

@Service
public class MembresiaService {
	@Autowired
	private MembresiaRepository membresiaRepository;
	
	public Membresia registrar(MembresiaDto membresiaDto) {
		Membresia membresia = new Membresia();
		membresia.setNombreMembresia(membresiaDto.getNombreMembresia());
		membresia.setDescripcion(membresiaDto.getDescripcion());
		membresia.setPrecio(membresiaDto.getPrecio());
		membresia.setVigencia(membresiaDto.getVigencia());
		
		return membresiaRepository.save(membresia);
	}
	
	public Membresia editarMembresia(Integer id, MembresiaDto membresiaDto) {
	    Membresia membresia = membresiaRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Membresía no encontrada con ID: " + id));

	    membresia.setNombreMembresia(membresiaDto.getNombreMembresia());
	    membresia.setDescripcion(membresiaDto.getDescripcion());
	    membresia.setPrecio(membresiaDto.getPrecio());
	    membresia.setVigencia(membresiaDto.getVigencia());

	    return membresiaRepository.save(membresia);
	}


	
}
