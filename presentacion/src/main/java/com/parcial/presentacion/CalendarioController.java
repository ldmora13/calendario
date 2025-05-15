package com.parcial.presentacion;

import com.parcial.core.ICalendarioServicio;
import com.parcial.dominio.Festivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final ICalendarioServicio calendarioServicio;

    public CalendarioController(ICalendarioServicio calendarioServicio) {
        this.calendarioServicio = calendarioServicio;
    }

    /**
     * Consulta si una fecha es festiva en un país dado.
     * Ejemplo: /api/calendario/es-festivo?paisId=1&fecha=2024-03-25
     */
    @GetMapping("/es-festivo")
    public ResponseEntity<?> esFestivo(
            @RequestParam Long paisId,
            @RequestParam String fecha) {

        try {
            LocalDate fechaParseada = LocalDate.parse(fecha); // formato esperado: yyyy-MM-dd
            boolean resultado = calendarioServicio.esFestivo(paisId, fechaParseada);

            return ResponseEntity.ok(Map.of(
                    "fecha", fechaParseada,
                    "paisId", paisId,
                    "esFestivo", resultado
            ));
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Formato de fecha inválido. Usa yyyy-MM-dd",
                    "detalle", e.getMessage()
            ));
        }
    }

    /**
     * Devuelve los festivos de un país para un año determinado.
     * Ejemplo: /api/calendario/festivos?paisId=1&anio=2024
     */
    @GetMapping("/festivos")
    public ResponseEntity<List<Festivo>> obtenerFestivosPorAnio(
            @RequestParam Long paisId,
            @RequestParam int anio) {

        List<Festivo> festivos = calendarioServicio.obtenerFestivosPorAnio(paisId, anio);
        return ResponseEntity.ok(festivos);
    }
}
