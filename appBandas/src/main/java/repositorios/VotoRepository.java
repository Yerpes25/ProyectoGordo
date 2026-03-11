package repositorios;

import modelos.Voto;
import modelos.VotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Voto. Utiliza una clave primaria compuesta (VotoId).
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId> {
}