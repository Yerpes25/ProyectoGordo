package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.AsignacionBorla;
import com.example.appBandas.modelos.AsignacionBorlaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla Asignacion_Borlas.
 */
@Repository
public interface AsignacionBorlaRepository extends JpaRepository<AsignacionBorla, AsignacionBorlaId> {
}