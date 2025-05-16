package com.miempresa.calendario.core;

import com.miempresa.calendario.dominio.Festivo;

import java.time.LocalDate;
import java.util.List;

public interface ICalendarioServicio {

    /**
     * Devuelve true si la fecha indicada es festiva en el país indicado.
     */
    boolean esFestivo(Long paisId, LocalDate fecha);

    /**
     * Devuelve todos los festivos de un país para un año determinado.
     */
    List<Festivo> obtenerFestivosPorAnio(Long paisId, int anio);
}
