package com.example.appBandas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.Banda;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Banda.
 */
@Repository
public interface BandaRepository extends JpaRepository<Banda, Integer> {
}