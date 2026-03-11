package controladores;

import modelos.Instrumento;
import servicios.InstrumentoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para el catálogo de instrumentos.
 */
@RestController
@RequestMapping("/api/instrumentos")
public class InstrumentoControlador {

    private final InstrumentoServicio instrumentoServicio;

    public InstrumentoControlador(InstrumentoServicio instrumentoServicio) {
        this.instrumentoServicio = instrumentoServicio;
    }

    @GetMapping
    public List<Instrumento> obtenerTodos() {
        return instrumentoServicio.obtenerTodosLosInstrumentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrumento> obtenerPorId(@PathVariable Integer id) {
        Optional<Instrumento> instrumento = instrumentoServicio.obtenerInstrumentoPorId(id);
        if (instrumento.isPresent()) {
            return ResponseEntity.ok(instrumento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Instrumento> guardar(@RequestBody Instrumento instrumento) {
        return ResponseEntity.ok(instrumentoServicio.guardarInstrumento(instrumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        instrumentoServicio.eliminarInstrumento(id);
        return ResponseEntity.ok().build();
    }
}