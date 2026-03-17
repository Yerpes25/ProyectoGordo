package com.example.appBandas.repositorios.eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.eventos.Asistencia;
import com.example.appBandas.modelos.eventos.AsistenciaId;

/**
 * Repositorio para gestionar la asistencia. Al usar clave compuesta, se indica
 * AsistenciaId como el tipo de ID.
 */
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, AsistenciaId> {
}