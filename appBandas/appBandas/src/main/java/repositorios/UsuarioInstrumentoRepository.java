package repositorios;

import modelos.UsuarioInstrumento;
import modelos.UsuarioInstrumentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * UsuarioInstrumento. Utiliza una clave primaria compuesta
 * (UsuarioInstrumentoId).
 */
@Repository
public interface UsuarioInstrumentoRepository extends JpaRepository<UsuarioInstrumento, UsuarioInstrumentoId> {
}