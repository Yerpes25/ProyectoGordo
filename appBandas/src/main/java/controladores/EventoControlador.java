package controladores;

import modelos.Evento;
import servicios.EventoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que gestiona las peticiones HTTP para la entidad Evento.
 * Permite a la aplicacion movil acceder a la agenda de la banda, visualizando
 * ensayos, conciertos y actuaciones programadas.
 */
@RestController
@RequestMapping("/api/eventos")
public class EventoControlador {

    private final EventoServicio eventoServicio;

    public EventoControlador(EventoServicio eventoServicio) {
        this.eventoServicio = eventoServicio;
    }

    @GetMapping
    public List<Evento> obtenerTodos() {
        return eventoServicio.obtenerTodosLosEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Integer id) {
        Optional<Evento> evento = eventoServicio.obtenerEventoPorId(id);
        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/banda/{idBanda}")
    public List<Evento> obtenerPorBanda(@PathVariable Integer idBanda) {
        return eventoServicio.obtenerEventosPorBanda(idBanda);
    }

    @PostMapping
    public ResponseEntity<Evento> guardar(@RequestBody Evento evento) {
        Evento eventoGuardado = eventoServicio.guardarEvento(evento);
        return ResponseEntity.ok(eventoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eventoServicio.eliminarEvento(id);
        return ResponseEntity.ok().build();
    }
}