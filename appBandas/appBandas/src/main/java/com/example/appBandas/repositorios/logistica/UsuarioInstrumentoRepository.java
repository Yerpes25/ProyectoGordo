package com.example.appBandas.repositorios.logistica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.logistica.UsuarioInstrumento;
import com.example.appBandas.modelos.logistica.UsuarioInstrumentoId;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * UsuarioInstrumento. Utiliza una clave primaria compuesta
 * (UsuarioInstrumentoId).
 */
@Repository
public interface UsuarioInstrumentoRepository extends JpaRepository<UsuarioInstrumento, UsuarioInstrumentoId> {
}