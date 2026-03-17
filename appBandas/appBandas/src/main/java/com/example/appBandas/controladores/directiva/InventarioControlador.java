package com.example.appBandas.controladores.directiva;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appBandas.modelos.logistica.Inventario;
import com.example.appBandas.servicios.logistica.InventarioServicio;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar el inventario de la banda.
 * Permite a la app móvil consultar el stock de instrumentos y uniformes,
 * ideal para conectarlo con un lector de códigos QR en Android.
 */
@RestController
@RequestMapping("/api/inventario")
public class InventarioControlador {

    private final InventarioServicio inventarioServicio;

    public InventarioControlador(InventarioServicio inventarioServicio) {
        this.inventarioServicio = inventarioServicio;
    }

    @GetMapping
    public List<Inventario> obtenerTodos() {
        return inventarioServicio.obtenerTodoElInventario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerPorId(@PathVariable Integer id) {
        Optional<Inventario> articulo = inventarioServicio.obtenerArticuloPorId(id);
        if (articulo.isPresent()) {
            return ResponseEntity.ok(articulo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Inventario> guardar(@RequestBody Inventario articulo) {
        Inventario articuloGuardado = inventarioServicio.guardarArticulo(articulo);
        return ResponseEntity.ok(articuloGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        inventarioServicio.eliminarArticulo(id);
        return ResponseEntity.ok().build();
    }
}