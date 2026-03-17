package com.example.appBandas.modelos.musica;

import com.example.appBandas.modelos.institucion.Banda;

import jakarta.persistence.*;

/**
 * Entidad que representa las composiciones musicales del repertorio de la
 * banda. Almacena el nombre de la marcha y su autor.
 */
@Entity
@Table(name = "Marchas")
public class Marcha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMarcha")
	private Integer idMarcha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanda", nullable = false)
	private Banda banda;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "autor", length = 100)
	private String autor;

	public Marcha() {
	}

	public Integer getIdMarcha() {
		return idMarcha;
	}

	public void setIdMarcha(Integer idMarcha) {
		this.idMarcha = idMarcha;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
