package repositorios;

import modelos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Evento.
 */
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

	/**
	 * Busca todos los eventos asociados a una banda específica.
	 * 
	 * @param idBanda El identificador de la banda.
	 * @return Una lista de eventos.
	 */
	List<Evento> findByBandaIdBanda(Integer idBanda);
}