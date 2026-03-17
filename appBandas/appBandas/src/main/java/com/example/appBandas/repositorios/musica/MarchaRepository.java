package com.example.appBandas.repositorios.musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.musica.Marcha;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Marcha.
 */
@Repository
public interface MarchaRepository extends JpaRepository<Marcha, Integer> {
}