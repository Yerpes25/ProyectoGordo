package repositorios;

import modelos.RolCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * RolCargo.
 */
@Repository
public interface RolCargoRepository extends JpaRepository<RolCargo, Integer> {
}