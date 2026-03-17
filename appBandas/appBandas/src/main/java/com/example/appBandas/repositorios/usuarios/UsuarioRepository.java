package com.example.appBandas.repositorios.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appBandas.modelos.usuarios.Usuario;

import java.util.Optional;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad
 * Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	/**
	 * Busca un usuario por su DNI.
	 * 
	 * @param dni El documento de identidad.
	 * @return Un Optional con el usuario si existe.
	 */
	Optional<Usuario> findByDni(String dni);

	/**
	 * Busca un usuario por su email para el inicio de sesión.
	 * 
	 * @param email El correo electrónico.
	 * @return Un Optional con el usuario si existe.
	 */
	Optional<Usuario> findByEmail(String email);
}