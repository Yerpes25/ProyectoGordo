package servicios;

import modelos.Evento;
import repositorios.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar los eventos (ensayos, actuaciones, etc.).
 */
@Service
public class EventoServicio {

    private final EventoRepository eventoRepository;

    public EventoServicio(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> obtenerEventoPorId(Integer id) {
        return eventoRepository.findById(id);
    }

    /**
     * Devuelve una lista de eventos que pertenecen exclusivamente a una banda.
     */
    public List<Evento> obtenerEventosPorBanda(Integer idBanda) {
        return eventoRepository.findByBandaIdBanda(idBanda);
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void eliminarEvento(Integer id) {
        eventoRepository.deleteById(id);
    }
}