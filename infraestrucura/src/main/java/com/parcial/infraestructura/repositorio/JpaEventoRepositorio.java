package com.parcial.infraestructura.repositorio;

import com.parcial.dominio.entidad.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JpaEventoRepositorio extends JpaRepository<Evento, Long> {
    Optional<Evento> findByFecha(LocalDate fecha);
    List<Evento> findByPais(String pais);
    List<Evento> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
