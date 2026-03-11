package repositorios;

import modelos.Partitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Partitura.
 */
@Repository
public interface PartituraRepository extends JpaRepository<Partitura, Integer> {
}