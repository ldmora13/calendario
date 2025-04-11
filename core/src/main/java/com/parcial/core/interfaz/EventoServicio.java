package com.parcial.core.interfaz;

import com.parcial.dominio.entidad.Evento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventoServicio {
    List<Evento> obtenerFestivosPorAnio(int anio);
    boolean esFechaFestiva(LocalDate fecha);
    Evento guardarEvento(Evento evento);
    Evento obtenerPorId(Long id);
    List<Evento> obtenerTodos();
    Evento actualizarEvento(Long id, Evento evento);
    void eliminarEvento(Long id);
    Optional<Evento> consultarPorFecha(LocalDate fecha);
    List<Evento> obtenerFestivosPorPais(String pais);

}
