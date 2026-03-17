package com.example.appBandas.repositorios.comunicacion;

import com.example.appBandas.modelos.comunicacion.LecturaAnuncio;
import com.example.appBandas.modelos.comunicacion.LecturaAnuncioId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla de lecturas de anuncios.
 */
@Repository
public interface LecturaAnuncioRepository extends JpaRepository<LecturaAnuncio, LecturaAnuncioId> {
}