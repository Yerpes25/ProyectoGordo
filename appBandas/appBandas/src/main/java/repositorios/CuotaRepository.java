package repositorios;

import modelos.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Cuota.
 */
@Repository
public interface CuotaRepository extends JpaRepository<Cuota, Integer> {
}