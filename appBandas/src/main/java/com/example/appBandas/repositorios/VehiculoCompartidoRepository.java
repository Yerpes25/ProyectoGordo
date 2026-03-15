package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.VehiculoCompartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para el acceso a datos de los vehiculos compartidos.
 */
@Repository
public interface VehiculoCompartidoRepository extends JpaRepository<VehiculoCompartido, Integer> {
}