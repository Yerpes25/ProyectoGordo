package com.example.appbandas.modelos;

/**
 * Modelo de datos que representa a un miembro de la banda.
 * Sus atributos deben coincidir exactamente con los nombres que devuelve el JSON de Spring Boot.
 */
public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String password;
    private String telefono;
    private String rolApp;

    // Constructor vacío requerido por Retrofit/Gson
    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRolApp() {
        return rolApp;
    }

    public void setRolApp(String rolApp) {
        this.rolApp = rolApp;
    }
}