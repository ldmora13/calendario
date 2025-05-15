package com.parcial.core;

import com.parcial.dominio.Festivo;

import java.util.List;

public interface IFestivoServicio {

    Festivo guardar(Festivo festivo);

    void eliminar(Long id);

    Festivo buscarPorId(Long id);

    List<Festivo> obtenerTodos();
}