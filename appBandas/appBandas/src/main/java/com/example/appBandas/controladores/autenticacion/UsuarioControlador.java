package com.example.appBandas.controladores.autenticacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appBandas.modelos.usuarios.Usuario;
import com.example.appBandas.servicios.usuarios.UsuarioServicio;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar las peticiones HTTP de los usuarios.
 * Esta clase actúa como la API para que la aplicación de Android pueda
 * registrar músicos, iniciar sesión y obtener sus datos en formato JSON.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioServicio.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioServicio.obtenerUsuarioPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String password) {
        Optional<Usuario> usuario = usuarioServicio.obtenerUsuarioPorEmail(email);
        
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario nuevoUsuario) {
        Usuario usuarioGuardado = usuarioServicio.guardarUsuario(nuevoUsuario);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioServicio.eliminarUsuario(id);
        return ResponseEntity.ok().build();
    }
}