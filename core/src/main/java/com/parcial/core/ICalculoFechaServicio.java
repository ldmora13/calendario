package com.parcial.core;

import com.parcial.dominio.Festivo;

import java.time.LocalDate;

public interface ICalculoFechaServicio {

    LocalDate calcularFechaFestivo(Festivo festivo, int anio);

    LocalDate calcularPascua(int anio);

    LocalDate moverALunes(LocalDate fecha);
}
