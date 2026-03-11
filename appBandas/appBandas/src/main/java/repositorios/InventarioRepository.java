package repositorios;

import modelos.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Inventario.
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}