package repositorios;

import modelos.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Seccion.
 */
@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
}