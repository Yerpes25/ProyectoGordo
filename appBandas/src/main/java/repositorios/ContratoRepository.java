package repositorios;

import modelos.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Contrato.
 */
@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}