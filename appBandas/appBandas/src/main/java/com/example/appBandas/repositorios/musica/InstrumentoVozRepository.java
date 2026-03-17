package com.example.appBandas.repositorios.musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.musica.InstrumentoVoz;
import com.example.appBandas.modelos.musica.InstrumentoVozId;

/**
 * Repositorio para gestionar las operaciones de base de datos de la entidad
 * InstrumentoVoz. Utiliza una clave primaria compuesta (InstrumentoVozId).
 */
@Repository
public interface InstrumentoVozRepository extends JpaRepository<InstrumentoVoz, InstrumentoVozId> {
}