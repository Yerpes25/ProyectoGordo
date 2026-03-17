package com.example.appBandas.repositorios.comunicacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.comunicacion.Votacion;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Votacion.
 */
@Repository
public interface VotacionRepository extends JpaRepository<Votacion, Integer> {
}