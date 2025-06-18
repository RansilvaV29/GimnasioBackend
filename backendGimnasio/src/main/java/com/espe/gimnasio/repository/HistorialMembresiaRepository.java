package com.espe.gimnasio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espe.gimnasio.entity.Historialmambresia;

@Repository
public interface HistorialMembresiaRepository extends JpaRepository<Historialmambresia, Integer>{
	List<Historialmambresia> findByEstadoTrueAndFechaFinBefore(Date fecha);
}
