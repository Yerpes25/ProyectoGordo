package com.example.appBandas.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appBandas.modelos.Banda;
import com.example.appBandas.servicios.BandaServicio;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las peticiones HTTP para la entidad Banda.
 * Proporciona los puntos de acceso (endpoints) para que la aplicacion cliente 
 * (Android) pueda consultar, crear, modificar y eliminar la informacion de la asociación musical.
 */
@RestController
@RequestMapping("/api/bandas")
public class BandaControlador {

    private final BandaServicio bandaServicio;

    public BandaControlador(BandaServicio bandaServicio) {
        this.bandaServicio = bandaServicio;
    }

    @GetMapping
    public List<Banda> obtenerTodas() {
        return bandaServicio.obtenerTodasLasBandas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banda> obtenerPorId(@PathVariable Integer id) {
        Optional<Banda> banda = bandaServicio.obtenerBandaPorId(id);
        if (banda.isPresent()) {
            return ResponseEntity.ok(banda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Banda> guardar(@RequestBody Banda banda) {
        Banda bandaGuardada = bandaServicio.guardarBanda(banda);
        return ResponseEntity.ok(bandaGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        bandaServicio.eliminarBanda(id);
        return ResponseEntity.ok().build();
    }
}