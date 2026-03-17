package com.example.appBandas.servicios.logistica;

import org.springframework.stereotype.Service;

import com.example.appBandas.modelos.logistica.Inventario;
import com.example.appBandas.repositorios.logistica.InventarioRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar los activos de la banda.
 * Útil para la posterior lectura e identificación mediante códigos QR.
 */
@Service
public class InventarioServicio {

    private final InventarioRepository inventarioRepository;

    public InventarioServicio(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> obtenerTodoElInventario() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerArticuloPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public Inventario guardarArticulo(Inventario articulo) {
        return inventarioRepository.save(articulo);
    }

    public void eliminarArticulo(Integer id) {
        inventarioRepository.deleteById(id);
    }
}