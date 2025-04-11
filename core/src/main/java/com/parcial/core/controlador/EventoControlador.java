package com.parcial.core.controlador;

import com.parcial.core.interfaz.EventoServicio;
import com.parcial.dominio.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoControlador {

    @Autowired
    private EventoServicio servicio;

    @PostMapping
    public ResponseEntity<Evento> guardar(@RequestBody Evento evento) {
        Evento creado = servicio.guardarEvento(evento);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Long id) {
        try {
            Evento evento = servicio.obtenerPorId(id);
            return ResponseEntity.ok(evento);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Evento>> obtenerTodos() {
        return ResponseEntity.ok(servicio.obtenerTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        try {
            Evento actualizado = servicio.actualizarEvento(id, evento);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            servicio.eliminarEvento(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/validar/{fecha}")
    public ResponseEntity<Boolean> validarFechaFestiva(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        boolean esFestiva = servicio.esFechaFestiva(fecha);
        return ResponseEntity.ok(esFestiva);
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<Evento>> listarFestivosPorAnio(@PathVariable int anio) {
        List<Evento> eventos = servicio.obtenerFestivosPorAnio(anio);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<Evento> consultarPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return servicio.consultarPorFecha(fecha)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Evento>> obtenerFestivosPorPais(@PathVariable String pais) {
        List<Evento> eventos = servicio.obtenerFestivosPorPais(pais);
        return ResponseEntity.ok(eventos);
    }

}

