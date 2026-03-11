package servicios;

import modelos.Inventario;
import repositorios.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar los activos de la banda.
 * Útil para la posterior lectura e identificación mediante códigos QR.
 */
@Service
public class InventarioServicio {

    private final InventarioRepository inventarioRepository;

    public InventarioServicio(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> obtenerTodoElInventario() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerArticuloPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public Inventario guardarArticulo(Inventario articulo) {
        return inventarioRepository.save(articulo);
    }

    public void eliminarArticulo(Integer id) {
        inventarioRepository.deleteById(id);
    }
}