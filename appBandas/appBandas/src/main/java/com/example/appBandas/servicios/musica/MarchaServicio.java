package com.example.appBandas.servicios.musica;

import org.springframework.stereotype.Service;

import com.example.appBandas.modelos.musica.Marcha;
import com.example.appBandas.repositorios.musica.MarchaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar el repertorio musical de la banda.
 */
@Service
public class MarchaServicio {

    private final MarchaRepository marchaRepository;

    public MarchaServicio(MarchaRepository marchaRepository) {
        this.marchaRepository = marchaRepository;
    }

    public List<Marcha> obtenerTodasLasMarchas() {
        return marchaRepository.findAll();
    }

    public Optional<Marcha> obtenerMarchaPorId(Integer id) {
        return marchaRepository.findById(id);
    }

    public Marcha guardarMarcha(Marcha marcha) {
        return marchaRepository.save(marcha);
    }

    public void eliminarMarcha(Integer id) {
        marchaRepository.deleteById(id);
    }
}