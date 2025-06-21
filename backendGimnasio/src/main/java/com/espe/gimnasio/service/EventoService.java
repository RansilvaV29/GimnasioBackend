package com.espe.gimnasio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espe.gimnasio.dto.EventoDto;
import com.espe.gimnasio.entity.Evento;
import com.espe.gimnasio.repository.EventoRepository;

@Service 
public class EventoService {
	@Autowired
    private EventoRepository eventoRepository;

    public Evento crearEvento(EventoDto dto) {
    	
    	Date hoy = new Date();
        if (dto.getFecha().before(hoy)) {
            throw new RuntimeException("La fecha del evento no puede ser menor a la fecha actual.");
        }

        // Validar que horaFin > horaInicio
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date horaInicio = sdf.parse(dto.getHoraInicio());
            Date horaFin = sdf.parse(dto.getHorraFin());

            if (!horaFin.after(horaInicio)) {
                throw new RuntimeException("La hora de fin debe ser mayor que la hora de inicio.");
            }

        } catch (ParseException e) {
            throw new RuntimeException("Formato de hora inválido. Use el formato HH:mm (ejemplo: 14:30).");
        }
        Evento evento = new Evento();
        evento.setNombreEvento(dto.getNombreEvento());
        evento.setDescripcion(dto.getDescripcion());
        evento.setCupoMaximo(dto.getCupoMaximo());
        evento.setFecha(dto.getFecha());
        evento.setHoraInicio(dto.getHoraInicio());
        evento.setHorraFin(dto.getHorraFin());
        return eventoRepository.save(evento);
    }
}
