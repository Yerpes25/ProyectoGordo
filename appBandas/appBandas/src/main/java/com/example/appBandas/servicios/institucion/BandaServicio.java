package com.example.appBandas.servicios.institucion;

import org.springframework.stereotype.Service;

import com.example.appBandas.modelos.institucion.Banda;
import com.example.appBandas.repositorios.institucion.BandaRepository;

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
    
    public Optional<Banda> obtenerBandaPorCif(String cif) {
        return bandaRepository.findByCif(cif);
    }

    public Banda guardarBanda(Banda banda) {
        return bandaRepository.save(banda);
    }

    public void eliminarBanda(Integer id) {
        bandaRepository.deleteById(id);
    }
}