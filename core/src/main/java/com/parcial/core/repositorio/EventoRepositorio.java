package com.parcial.core.repositorio;

import com.parcial.dominio.entidad.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {
    boolean existsByFecha(LocalDate fecha);
    List<Evento> findByFechaBetween(LocalDate inicio, LocalDate fin);
    Optional<Evento> findByFecha(LocalDate fecha);
    List<Evento> findByPaisIgnoreCase(String pais);

}