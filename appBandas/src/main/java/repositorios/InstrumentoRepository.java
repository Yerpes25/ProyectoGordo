package repositorios;

import modelos.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Instrumento.
 */
@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {
}