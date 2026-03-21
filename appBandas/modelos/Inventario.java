package com.example.appBandas.modelos;

import jakarta.persistence.*;

/**
 * Entidad que gestiona los activos físicos de la banda (instrumentos en stock,
 * uniformes). Incluye un código QR único para el control de préstamos y el
 * estado del artículo.
 */
@Entity
@Table(name = "Inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idArticulo")
	private Integer idArticulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanda", nullable = false)
	private Banda banda;

	@Column(name = "tipo", length = 50)
	private String tipo;

	@Column(name = "descripcion", length = 255)
	private String descripcion;

	@Column(name = "codigoQr", unique = true, length = 100)
	private String codigoQr;

	@Column(name = "estado", length = 50)
	private String estado;

	public Inventario() {
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoQr() {
		return codigoQr;
	}

	public void setCodigoQr(String codigoQr) {
		this.codigoQr = codigoQr;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}