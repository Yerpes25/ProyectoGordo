package com.example.appBandas.servicios.musica;

import org.springframework.stereotype.Service;

import com.example.appBandas.modelos.musica.Seccion;
import com.example.appBandas.repositorios.musica.SeccionRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para organizar los instrumentos por familias (Viento metal, percusión, etc.).
 */
@Service
public class SeccionServicio {

    private final SeccionRepository seccionRepository;

    public SeccionServicio(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }

    public List<Seccion> obtenerTodasLasSecciones() {
        return seccionRepository.findAll();
    }

    public Optional<Seccion> obtenerSeccionPorId(Integer id) {
        return seccionRepository.findById(id);
    }

    public Seccion guardarSeccion(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public void eliminarSeccion(Integer id) {
        seccionRepository.deleteById(id);
    }
}