package servicios;

import modelos.Instrumento;
import repositorios.InstrumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de los diferentes tipos de instrumentos (Cornetas, Tambores, etc.).
 */
@Service
public class InstrumentoServicio {

    private final InstrumentoRepository instrumentoRepository;

    public InstrumentoServicio(InstrumentoRepository instrumentoRepository) {
        this.instrumentoRepository = instrumentoRepository;
    }

    public List<Instrumento> obtenerTodosLosInstrumentos() {
        return instrumentoRepository.findAll();
    }

    public Optional<Instrumento> obtenerInstrumentoPorId(Integer id) {
        return instrumentoRepository.findById(id);
    }

    public Instrumento guardarInstrumento(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    public void eliminarInstrumento(Integer id) {
        instrumentoRepository.deleteById(id);
    }
}