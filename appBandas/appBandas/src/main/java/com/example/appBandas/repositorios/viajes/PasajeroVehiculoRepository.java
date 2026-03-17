package com.example.appBandas.repositorios.viajes;

import com.example.appBandas.modelos.viajes.PasajeroVehiculo;
import com.example.appBandas.modelos.viajes.PasajeroVehiculoId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a la tabla de Pasajeros_Vehiculo.
 */
@Repository
public interface PasajeroVehiculoRepository extends JpaRepository<PasajeroVehiculo, PasajeroVehiculoId> {
}