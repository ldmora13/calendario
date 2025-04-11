package com.parcial.core.servicio;

import com.parcial.core.interfaz.EventoServicio;
import com.parcial.core.repositorio.EventoRepositorio;
import com.parcial.dominio.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServicioImpl implements EventoServicio {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Override
    public Evento guardarEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    @Override
    public Evento obtenerPorId(Long id) {
        return eventoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));
    }

    @Override
    public List<Evento> obtenerTodos() {
        return eventoRepositorio.findAll();
    }

    @Override
    public Evento actualizarEvento(Long id, Evento eventoActualizado) {
        Evento evento = obtenerPorId(id);
        evento.setNombre(eventoActualizado.getNombre());
        evento.setFecha(eventoActualizado.getFecha());
        evento.setDescripcion(eventoActualizado.getDescripcion());
        return eventoRepositorio.save(evento);
    }

    @Override
    public void eliminarEvento(Long id) {
        Evento evento = obtenerPorId(id);
        eventoRepositorio.delete(evento);
    }

    @Override
    public boolean esFechaFestiva(LocalDate fecha) {
        return eventoRepositorio.existsByFecha(fecha);
    }

    @Override
    public List<Evento> obtenerFestivosPorAnio(int anio) {
        LocalDate inicio = LocalDate.of(anio, 1, 1);
        LocalDate fin = LocalDate.of(anio, 12, 31);
        return eventoRepositorio.findByFechaBetween(inicio, fin);
    }

    @Override
    public Optional<Evento> consultarPorFecha(LocalDate fecha) {
        return eventoRepositorio.findByFecha(fecha);
    }

    @Override
    public List<Evento> obtenerFestivosPorPais(String pais) {
        return eventoRepositorio.findByPaisIgnoreCase(pais);
    }

}

