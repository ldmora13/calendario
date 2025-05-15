package com.parcial.core;

import com.parcial.dominio.Festivo;

import java.time.LocalDate;
import java.util.List;

public interface ICalendarioServicio {

    boolean esFestivo(Long paisId, LocalDate fecha);

    List<Festivo> obtenerFestivosPorAnio(Long paisId, int anio);
}
