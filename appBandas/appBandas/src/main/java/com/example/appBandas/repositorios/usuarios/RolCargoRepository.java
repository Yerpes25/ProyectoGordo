package com.example.appBandas.repositorios.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.usuarios.RolCargo;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * RolCargo.
 */
@Repository
public interface RolCargoRepository extends JpaRepository<RolCargo, Integer> {
}