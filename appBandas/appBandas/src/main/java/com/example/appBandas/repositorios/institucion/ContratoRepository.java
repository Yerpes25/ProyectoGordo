package com.example.appBandas.repositorios.institucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.institucion.Contrato;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Contrato.
 */
@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}