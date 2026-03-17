package com.example.appBandas.repositorios.usuarios;

import com.example.appBandas.modelos.usuarios.UsuarioCargo;
import com.example.appBandas.modelos.usuarios.UsuarioCargoId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla de asignaciones de la junta.
 */
@Repository
public interface UsuarioCargoRepository extends JpaRepository<UsuarioCargo, UsuarioCargoId> {
}