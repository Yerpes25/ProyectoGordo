package repositorios;

import modelos.InstrumentoVoz;
import modelos.InstrumentoVozId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * InstrumentoVoz. Utiliza una clave primaria compuesta (InstrumentoVozId).
 */
@Repository
public interface InstrumentoVozRepository extends JpaRepository<InstrumentoVoz, InstrumentoVozId> {
}