package entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the GUACHERAS database table.
 * 
 */
@Entity
@Table(name="GUACHERAS")
@NamedQuery(name="Guachera.findAll", query="SELECT g FROM Guachera g")
public class Guachera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GUACHERAS_IDGUACHERA_GENERATOR", sequenceName="SEQ_GUACHERA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GUACHERAS_IDGUACHERA_GENERATOR")
	@Column(name="ID_GUACHERA")
	private long idGuachera;

	private String nombre;

	@Column(name="PK_GUACHERA")
	private String pkGuachera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Ternera
	@JsonIgnore
	@OneToMany(mappedBy="guachera")
	private List<Ternera> terneras;

	public Guachera() {
	}

	public long getIdGuachera() {
		return this.idGuachera;
	}

	public void setIdGuachera(long idGuachera) {
		this.idGuachera = idGuachera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPkGuachera() {
		return this.pkGuachera;
	}

	public void setPkGuachera(String pkGuachera) {
		this.pkGuachera = pkGuachera;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Ternera> getTerneras() {
		return this.terneras;
	}

	public void setTerneras(List<Ternera> terneras) {
		this.terneras = terneras;
	}

	public Ternera addTernera(Ternera ternera) {
		getTerneras().add(ternera);
		ternera.setGuachera(this);

		return ternera;
	}

	public Ternera removeTernera(Ternera ternera) {
		getTerneras().remove(ternera);
		ternera.setGuachera(null);

		return ternera;
	}

}