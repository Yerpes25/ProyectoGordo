package com.example.appBandas.repositorios.musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.musica.Partitura;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Partitura.
 */
@Repository
public interface PartituraRepository extends JpaRepository<Partitura, Integer> {
}