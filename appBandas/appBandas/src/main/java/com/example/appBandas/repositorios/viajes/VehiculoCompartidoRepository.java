package com.example.appBandas.repositorios.viajes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.viajes.VehiculoCompartido;

/**
 * Repositorio para el acceso a datos de los vehiculos compartidos.
 */
@Repository
public interface VehiculoCompartidoRepository extends JpaRepository<VehiculoCompartido, Integer> {
}