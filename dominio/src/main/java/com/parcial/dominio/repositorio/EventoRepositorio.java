package com.parcial.dominio.repositorio;

import com.parcial.dominio.entidad.Evento;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventoRepositorio {
    Optional<Evento> buscarPorId(Long id);
    Optional<Evento> buscarPorFecha(LocalDate fecha);
    List<Evento> buscarPorPais(String pais);
    List<Evento> buscarPorAno(int ano);
}
