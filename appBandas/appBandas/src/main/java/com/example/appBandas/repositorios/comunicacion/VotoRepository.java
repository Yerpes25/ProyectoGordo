package com.example.appBandas.repositorios.comunicacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.comunicacion.Voto;
import com.example.appBandas.modelos.comunicacion.VotoId;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * Voto. Utiliza una clave primaria compuesta (VotoId).
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId> {
}