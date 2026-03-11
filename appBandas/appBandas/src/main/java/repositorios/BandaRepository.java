package repositorios;

import modelos.Banda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Banda.
 */
@Repository
public interface BandaRepository extends JpaRepository<Banda, Integer> {
}