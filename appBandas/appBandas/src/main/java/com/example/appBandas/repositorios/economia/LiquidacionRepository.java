package com.example.appBandas.repositorios.economia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.economia.Liquidacion;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Liquidacion.
 */
@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer> {
}