package com.example.appBandas.repositorios.institucion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.institucion.Banda;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Banda.
 */
@Repository
public interface BandaRepository extends JpaRepository<Banda, Integer> {
	// Nueva linea para que busque una banda usando su CIF
    Optional<Banda> findByCif(String cif);
}