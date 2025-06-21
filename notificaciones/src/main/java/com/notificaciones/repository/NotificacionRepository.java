package com.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificaciones.entity.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
