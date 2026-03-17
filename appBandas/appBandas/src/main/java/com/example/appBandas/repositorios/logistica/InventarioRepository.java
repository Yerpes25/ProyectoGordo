package com.example.appBandas.repositorios.logistica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.logistica.Inventario;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Inventario.
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}