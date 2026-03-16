package com.example.appBandas.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidad que representa a una banda de música en el sistema. Sirve como eje
 * central para agrupar usuarios, eventos, inventario y demás recursos.
 * Ahora incluye el color corporativo para la interfaz de la aplicación.
 */
@Entity
@Table(name = "Bandas")
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBanda")
	private Integer idBanda;

	@Column(name = "Nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "cif", length = 20)
	private String cif;

	@JsonProperty("fFundacion")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "f_fundacion")
	private LocalDate fFundacion;

	// Atributo añadido para guardar el color hexadecimal (ej. #FF0000)
	@Column(name = "color_primario", length = 10)
	private String colorPrimario;

	@JsonIgnore
	@OneToMany(mappedBy = "banda", cascade = CascadeType.ALL)
	private List<Usuario> usuarios;

	@JsonIgnore
	@OneToMany(mappedBy = "banda", cascade = CascadeType.ALL)
	private List<Evento> eventos;

	// Constructores
	public Banda() {
	}

	// Getters y Setters
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

	public LocalDate getfFundacion() {
		return fFundacion;
	}

	public void setfFundacion(LocalDate fFundacion) {
		this.fFundacion = fFundacion;
	}

	public String getColorPrimario() {
		return colorPrimario;
	}

	public void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}