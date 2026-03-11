package repositorios;

import modelos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Prestamo.
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}