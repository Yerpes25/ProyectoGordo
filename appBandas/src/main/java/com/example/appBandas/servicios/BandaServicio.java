package com.example.appBandas.servicios;

import org.springframework.stereotype.Service;

import com.example.appBandas.modelos.Banda;
import com.example.appBandas.repositorios.BandaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio de las bandas.
 */
@Service
public class BandaServicio {

    private final BandaRepository bandaRepository;

    public BandaServicio(BandaRepository bandaRepository) {
        this.bandaRepository = bandaRepository;
    }

    public List<Banda> obtenerTodasLasBandas() {
        return bandaRepository.findAll();
    }

    public Optional<Banda> obtenerBandaPorId(Integer id) {
        return bandaRepository.findById(id);
    }

    public Banda guardarBanda(Banda banda) {
        return bandaRepository.save(banda);
    }

    public void eliminarBanda(Integer id) {
        bandaRepository.deleteById(id);
    }
}