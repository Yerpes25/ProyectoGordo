package modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que define un evento organizado por la banda, como un ensayo,
 * procesión o concierto. Contiene la información de fecha, hora y ubicación
 * para el control de asistencia.
 */
@Entity
@Table(name = "Eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento")
	private Integer idEvento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanda", nullable = false)
	private Banda banda;

	@Column(name = "tipo", length = 50)
	private String tipo;

	@Column(name = "fHora", nullable = false)
	private LocalDateTime fHora;

	@Column(name = "direccion", length = 255)
	private String direccion;

	@Column(name = "latitud", precision = 10, scale = 8)
	private Double latitud;

	@Column(name = "longitud", precision = 11, scale = 8)
	private Double longitud;

	// Constructores
	public Evento() {
	}

	// Getters y Setters
	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
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

	public LocalDateTime getfHora() {
		return fHora;
	}

	public void setfHora(LocalDateTime fHora) {
		this.fHora = fHora;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
}