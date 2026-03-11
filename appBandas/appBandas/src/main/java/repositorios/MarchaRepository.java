package repositorios;

import modelos.Marcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Marcha.
 */
@Repository
public interface MarchaRepository extends JpaRepository<Marcha, Integer> {
}