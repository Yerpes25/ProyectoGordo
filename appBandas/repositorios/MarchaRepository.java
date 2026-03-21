package com.example.appBandas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.Marcha;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Marcha.
 */
@Repository
public interface MarchaRepository extends JpaRepository<Marcha, Integer> {
}