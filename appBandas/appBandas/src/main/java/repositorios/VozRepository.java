package repositorios;

import modelos.Voz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Voz.
 */
@Repository
public interface VozRepository extends JpaRepository<Voz, Integer> {
}