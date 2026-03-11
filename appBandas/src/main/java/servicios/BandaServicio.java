package servicios;

import modelos.Banda;
import repositorios.BandaRepository;
import org.springframework.stereotype.Service;

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