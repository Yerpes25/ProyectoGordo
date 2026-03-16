package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.UsuarioCargo;
import com.example.appBandas.modelos.UsuarioCargoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla de asignaciones de la junta.
 */
@Repository
public interface UsuarioCargoRepository extends JpaRepository<UsuarioCargo, UsuarioCargoId> {
}