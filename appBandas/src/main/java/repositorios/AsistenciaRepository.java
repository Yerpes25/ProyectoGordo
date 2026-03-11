package repositorios;

import modelos.Asistencia;
import modelos.AsistenciaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar la asistencia. Al usar clave compuesta, se indica
 * AsistenciaId como el tipo de ID.
 */
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, AsistenciaId> {
}