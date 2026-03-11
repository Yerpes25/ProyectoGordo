package repositorios;

import modelos.Insignia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Insignia.
 */
@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, Integer> {
}