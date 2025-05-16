package com.miempresa.calendario.presentacion;

import com.miempresa.calendario.core.ICalendarioServicio;
import com.miempresa.calendario.dominio.Festivo;
import com.miempresa.calendario.dto.FestivoDto;
import com.miempresa.calendario.infraestructura.repositorio.PaisRepositorio;
import com.miempresa.calendario.dominio.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final ICalendarioServicio calendarioServicio;
    private final PaisRepositorio paisRepositorio;

    public CalendarioController(ICalendarioServicio calendarioServicio, PaisRepositorio paisRepositorio) {
        this.calendarioServicio = calendarioServicio;
        this.paisRepositorio = paisRepositorio;
    }

    @GetMapping("/es-festivo")
    public ResponseEntity<?> esFestivo(
            @RequestParam Long paisId,
            @RequestParam String fecha) {

        try {
            LocalDate fechaParseada = LocalDate.parse(fecha);
            boolean resultado = calendarioServicio.esFestivo(paisId, fechaParseada);

            // Obtener nombre del país
            Optional<Pais> paisOpt = paisRepositorio.findById(paisId);
            String nombrePais = paisOpt.map(Pais::getNombre).orElse("Desconocido");

            return ResponseEntity.ok(Map.of(
                    "fecha", fechaParseada,
                    "paisId", paisId,
                    "paisNombre", nombrePais,
                    "esFestivo", resultado
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Formato de fecha inválido. Usa yyyy-MM-dd",
                    "detalle", e.getMessage()
            ));
        }
    }

    @GetMapping("/festivos")
    public ResponseEntity<List<FestivoDto>> obtenerFestivosPorAnio(
            @RequestParam Long paisId,
            @RequestParam int anio) {

        List<Festivo> festivos = calendarioServicio.obtenerFestivosPorAnio(paisId, anio);

        List<FestivoDto> dtos = festivos.stream()
                .map(this::convertirAFestivoDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    private FestivoDto convertirAFestivoDto(Festivo festivo) {
        FestivoDto dto = new FestivoDto();
        dto.setId(festivo.getId());
        dto.setNombre(festivo.getNombre());
        dto.setDia(festivo.getDia());
        dto.setMes(festivo.getMes());
        dto.setDiasPascua(festivo.getDiasPascua());
        dto.setPaisNombre(festivo.getPais().getNombre());
        dto.setTipoNombre(festivo.getTipo().getTipo());
        return dto;
    }
}
