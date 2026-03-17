package com.example.appBandas.repositorios.logistica;

import com.example.appBandas.modelos.logistica.AsignacionBorla;
import com.example.appBandas.modelos.logistica.AsignacionBorlaId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla Asignacion_Borlas.
 */
@Repository
public interface AsignacionBorlaRepository extends JpaRepository<AsignacionBorla, AsignacionBorlaId> {
}