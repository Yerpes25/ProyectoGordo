package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.GaleriaMultimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para el acceso a datos de la galeria multimedia.
 */
@Repository
public interface GaleriaMultimediaRepository extends JpaRepository<GaleriaMultimedia, Integer> {
}