package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQueries({
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
@NamedQuery(name="Usuario.usuarioValido", query="SELECT COUNT(u) FROM Usuario u WHERE u.usuario LIKE :usuario AND u.contrasenia LIKE :contrasenia")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSUARIO_GENERATOR", sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSUARIO_GENERATOR")
	@Column(name="ID_USUARIO")
	private long idUsuario;

	private String apellido;

	private String contrasenia;

	private String nombre;

	private String perfil;

	private String usuario;

	//bi-directional many-to-one association to Guachera
	@OneToMany(mappedBy="usuario")
	private List<Guachera> guacheras;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Guachera> getGuacheras() {
		return this.guacheras;
	}

	public void setGuacheras(List<Guachera> guacheras) {
		this.guacheras = guacheras;
	}

	public Guachera addGuachera(Guachera guachera) {
		getGuacheras().add(guachera);
		guachera.setUsuario(this);

		return guachera;
	}

	public Guachera removeGuachera(Guachera guachera) {
		getGuacheras().remove(guachera);
		guachera.setUsuario(null);

		return guachera;
	}

}