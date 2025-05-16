package com.miempresa.calendario.infraestructura.servicio;

import com.miempresa.calendario.core.ICalculoFechaServicio;
import com.miempresa.calendario.dominio.Festivo;
/* import com.miempresa.calendario.dominio.Tipo; */
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Service
public class CalculoFechaServicioImpl implements ICalculoFechaServicio {

    @Override
    public LocalDate calcularFechaFestivo(Festivo festivo, int anio) {
        Long tipoId = festivo.getTipo().getId();
        int diasPascua = festivo.getDiasPascua();

        switch (tipoId.intValue()) {
            case 1: // Fijo
                return LocalDate.of(anio, festivo.getMes(), festivo.getDia());
/*  */
            case 2: // Puente festivo (mover a lunes)
                return moverALunes(LocalDate.of(anio, festivo.getMes(), festivo.getDia()));

            case 3: // Basado en Pascua
                return calcularPascua(anio).plusDays(diasPascua);

            case 4: // Basado en Pascua + mover a lunes
                return moverALunes(calcularPascua(anio).plusDays(diasPascua));

            case 5: // Ley Puente Festivo Viernes (tipo adicional)
                return moverAViernes(LocalDate.of(anio, festivo.getMes(), festivo.getDia()));

            default:
                throw new IllegalArgumentException("Tipo de festivo no soportado: " + tipoId);
        }
    }

    @Override
    public LocalDate calcularPascua(int anio) {
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e;
        LocalDate ramos = LocalDate.of(anio, Month.MARCH, 15).plusDays(dias);
        return ramos.plusDays(7); // domingo siguiente a ramos
    }

    @Override
    public LocalDate moverALunes(LocalDate fecha) {
        return fecha.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
    }

    public LocalDate moverAViernes(LocalDate fecha) {
        return fecha.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
    }
}
