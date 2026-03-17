package com.example.appBandas.repositorios.logistica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.logistica.Prestamo;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Prestamo.
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}