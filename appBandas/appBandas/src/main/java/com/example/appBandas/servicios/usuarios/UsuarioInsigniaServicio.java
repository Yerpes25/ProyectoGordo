package com.example.appBandas.servicios.usuarios;

import com.example.appBandas.modelos.usuarios.UsuarioInsignia;
import com.example.appBandas.modelos.usuarios.UsuarioInsigniaId;
import com.example.appBandas.repositorios.usuarios.UsuarioInsigniaRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar la asignacion de insignias a los musicos.
 */
@Service
public class UsuarioInsigniaServicio {

    private final UsuarioInsigniaRepository usuarioInsigniaRepository;

    public UsuarioInsigniaServicio(UsuarioInsigniaRepository usuarioInsigniaRepository) {
        this.usuarioInsigniaRepository = usuarioInsigniaRepository;
    }

    public List<UsuarioInsignia> obtenerTodas() {
        return usuarioInsigniaRepository.findAll();
    }

    public Optional<UsuarioInsignia> obtenerPorId(Integer idUsuario, Integer idInsignia) {
        UsuarioInsigniaId id = new UsuarioInsigniaId(idUsuario, idInsignia);
        return usuarioInsigniaRepository.findById(id);
    }

    public UsuarioInsignia guardar(UsuarioInsignia usuarioInsignia) {
        return usuarioInsigniaRepository.save(usuarioInsignia);
    }

    public void eliminar(Integer idUsuario, Integer idInsignia) {
        UsuarioInsigniaId id = new UsuarioInsigniaId(idUsuario, idInsignia);
        usuarioInsigniaRepository.deleteById(id);
    }
}