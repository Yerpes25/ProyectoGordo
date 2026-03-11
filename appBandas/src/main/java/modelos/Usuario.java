package modelos;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa a un músico o miembro de la directiva de la banda.
 * Almacena los datos personales, de contacto y de acceso a la aplicación.
 */
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Integer idUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanda", nullable = false)
	private Banda banda;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;

	@Column(name = "dni", unique = true, length = 20)
	private String dni;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "f_nacimiento")
	private LocalDate fNacimiento;

	@Column(name = "direccion", length = 255)
	private String direccion;

	@Column(name = "f_alta")
	private LocalDate fAlta;

	@Column(name = "activo", columnDefinition = "boolean default true")
	private Boolean activo;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "contactEmerg", length = 20)
	private String contactEmerg;

	@Column(name = "tallaChaqueta", length = 10)
	private String tallaChaqueta;

	@Column(name = "tallaPantalon", length = 10)
	private String tallaPantalon;

	@Column(name = "tallaGorra", length = 10)
	private String tallaGorra;

	@Column(name = "tallaCamisa", length = 10)
	private String tallaCamisa;

	@Column(name = "rolApp", length = 20)
	private String rolApp;

	// Constructores
	public Usuario() {
	}

	// Getters y Setters
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getfAlta() {
		return fAlta;
	}

	public void setfAlta(LocalDate fAlta) {
		this.fAlta = fAlta;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactEmerg() {
		return contactEmerg;
	}

	public void setContactEmerg(String contactEmerg) {
		this.contactEmerg = contactEmerg;
	}

	public String getTallaChaqueta() {
		return tallaChaqueta;
	}

	public void setTallaChaqueta(String tallaChaqueta) {
		this.tallaChaqueta = tallaChaqueta;
	}

	public String getTallaPantalon() {
		return tallaPantalon;
	}

	public void setTallaPantalon(String tallaPantalon) {
		this.tallaPantalon = tallaPantalon;
	}

	public String getTallaGorra() {
		return tallaGorra;
	}

	public void setTallaGorra(String tallaGorra) {
		this.tallaGorra = tallaGorra;
	}

	public String getTallaCamisa() {
		return tallaCamisa;
	}

	public void setTallaCamisa(String tallaCamisa) {
		this.tallaCamisa = tallaCamisa;
	}

	public String getRolApp() {
		return rolApp;
	}

	public void setRolApp(String rolApp) {
		this.rolApp = rolApp;
	}
}