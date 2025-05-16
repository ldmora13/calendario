package com.miempresa.calendario.core;

import com.miempresa.calendario.dominio.Festivo;

import java.time.LocalDate;

public interface ICalculoFechaServicio {

    /**
     * Devuelve la fecha real del festivo según el tipo y el año.
     */
    LocalDate calcularFechaFestivo(Festivo festivo, int anio);

    /**
     * Calcula el domingo de Pascua para un año dado.
     */
    LocalDate calcularPascua(int anio);

    /**
     * Mueve una fecha al siguiente lunes.
     */
    LocalDate moverALunes(LocalDate fecha);
}
