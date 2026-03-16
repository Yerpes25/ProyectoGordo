package com.example.appBandas.repositorios;

import com.example.appBandas.modelos.UsuarioInsignia;
import com.example.appBandas.modelos.UsuarioInsigniaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla de logros de los usuarios.
 */
@Repository
public interface UsuarioInsigniaRepository extends JpaRepository<UsuarioInsignia, UsuarioInsigniaId> {
}