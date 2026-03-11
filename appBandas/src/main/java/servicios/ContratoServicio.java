package servicios;

import modelos.Contrato;
import repositorios.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar los contratos firmados por la banda.
 */
@Service
public class ContratoServicio {

    private final ContratoRepository contratoRepository;

    public ContratoServicio(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<Contrato> obtenerTodosLosContratos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> obtenerContratoPorId(Integer id) {
        return contratoRepository.findById(id);
    }

    public Contrato guardarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void eliminarContrato(Integer id) {
        contratoRepository.deleteById(id);
    }
}