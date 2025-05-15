package com.parcial.infraestructura.servicio;

import com.parcial.core.ICalendarioServicio;
import com.parcial.core.ICalculoFechaServicio;
import com.parcial.dominio.Festivo;
import com.parcial.infraestructura.repositorio.FestivoRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarioServicioImpl implements ICalendarioServicio {

    private final FestivoRepositorio festivoRepositorio;
    private final ICalculoFechaServicio calculoFechaServicio;

    public CalendarioServicioImpl(FestivoRepositorio festivoRepositorio,
                                  ICalculoFechaServicio calculoFechaServicio) {
        this.festivoRepositorio = festivoRepositorio;
        this.calculoFechaServicio = calculoFechaServicio;
    }

    @Override
    public boolean esFestivo(Long paisId, LocalDate fecha) {
        List<Festivo> festivos = festivoRepositorio.findByPaisId(paisId);

        for (Festivo festivo : festivos) {
            LocalDate fechaCalculada = calculoFechaServicio.calcularFechaFestivo(festivo, fecha.getYear());
            if (fechaCalculada.equals(fecha)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Festivo> obtenerFestivosPorAnio(Long paisId, int anio) {
        List<Festivo> festivos = festivoRepositorio.findByPaisId(paisId);
        List<Festivo> resultado = new ArrayList<>();

        for (Festivo festivo : festivos) {
            LocalDate fechaCalculada = calculoFechaServicio.calcularFechaFestivo(festivo, anio);
            Festivo copia = new Festivo();
            copia.setId(festivo.getId());
            copia.setNombre(festivo.getNombre());
            copia.setPais(festivo.getPais());
            copia.setTipo(festivo.getTipo());
            copia.setDia(fechaCalculada.getDayOfMonth());
            copia.setMes(fechaCalculada.getMonthValue());
            copia.setDiasPascua(festivo.getDiasPascua());
            resultado.add(copia);
        }

        return resultado;
    }
}
