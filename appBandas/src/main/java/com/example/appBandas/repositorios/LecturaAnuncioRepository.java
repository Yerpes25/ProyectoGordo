package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.LecturaAnuncio;
import com.example.appBandas.modelos.LecturaAnuncioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla de lecturas de anuncios.
 */
@Repository
public interface LecturaAnuncioRepository extends JpaRepository<LecturaAnuncio, LecturaAnuncioId> {
}