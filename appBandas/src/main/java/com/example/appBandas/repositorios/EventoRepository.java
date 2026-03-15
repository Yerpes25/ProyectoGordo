package com.example.appBandas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.Evento;

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