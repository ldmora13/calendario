package com.parcial.infraestructura.repositorio;

import com.parcial.dominio.entidad.Evento;
import com.parcial.dominio.repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventoRepositorioImpl implements EventoRepositorio {

    private final JpaEventoRepositorio jpaRepositorio;

    @Autowired
    public EventoRepositorioImpl(JpaEventoRepositorio jpaRepositorio) {
        this.jpaRepositorio = jpaRepositorio;
    }

    @Override
    public Optional<Evento> buscarPorFecha(LocalDate fecha) {
        return jpaRepositorio.findByFecha(fecha);
    }

    @Override
    public List<Evento> buscarPorPais(String pais) {
        return jpaRepositorio.findByPais(pais);
    }

    @Override
    public List<Evento> buscarPorAno(int ano) {
        LocalDate inicio = LocalDate.of(ano, 1, 1);
        LocalDate fin = LocalDate.of(ano, 12, 31);
        return jpaRepositorio.findByFechaBetween(inicio, fin);
    }

    @Override
    public Optional<Evento> buscarPorId(Long id) {
        return jpaRepositorio.findById(id);
    }
}
