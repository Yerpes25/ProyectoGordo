package com.example.appbandas.modelos.institucion;

/**
 * Clase que representa la entidad Banda en la aplicacion movil.
 * Se utiliza para empaquetar los datos recogidos en el formulario
 * y enviarlos a la API REST, o para recibir los datos tras una busqueda.
 */
public class Banda {

    private Integer idBanda;
    private String nombre;
    private String cif;
    private String colorPrimario;

    public Banda(String nombre, String cif, String colorPrimario) {
        this.nombre = nombre;
        this.cif = cif;
        this.colorPrimario = colorPrimario;
    }

    public Integer getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Integer idBanda) {
        this.idBanda = idBanda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }
}