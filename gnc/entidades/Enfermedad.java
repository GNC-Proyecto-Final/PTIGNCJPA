package entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import enumerados.NombreEnfermedad;
import enumerados.convert.NombreEnfermedadConvert;

import java.util.List;


/**
 * The persistent class for the ENFERMEDADES database table.
 * 
 */
@Entity
@Table(name="ENFERMEDADES")
@NamedQueries({
@NamedQuery(name="Enfermedad.findAllEnfermedades", query="SELECT e FROM Enfermedad e"),
@NamedQuery(name="Enfermedad.findExisteEnfermedad", query="SELECT COUNT(e) FROM Enfermedad e WHERE e.nombre LIKE :nombre AND e.gradoGravedad LIKE :gradoGravedad"),
@NamedQuery(name="Enfermedad.obtenerEnfermedadId", query="SELECT e FROM Enfermedad e WHERE e.idEnfermedad = :idEnfermedad")
}) 
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENFERMEDADES_IDENFERMEDAD_GENERATOR", sequenceName="SEQ_ENFERMEDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENFERMEDADES_IDENFERMEDAD_GENERATOR")
	@Column(name="ID_ENFERMEDAD")
	private long idEnfermedad;

	@Column(name="GRADO_GRAVEDAD")
	private long gradoGravedad;

	//@Enumerated(value = EnumType.STRING)
	@Convert(converter = NombreEnfermedadConvert.class)
	private NombreEnfermedad nombre;
	
	
	
	//bi-directional many-to-one association to EnfermedadTernera
	@JsonIgnore
	@OneToMany(mappedBy="enfermedad")
	private List<EnfermedadTernera> enfermedadTerneras;

	public Enfermedad() {
	}
	

	public Enfermedad(long gradoGravedad, NombreEnfermedad nombre) {
		this.gradoGravedad = gradoGravedad;
		this.nombre = nombre;
	}


	public long getIdEnfermedad() {
		return this.idEnfermedad;
	}

	public void setIdEnfermedad(long idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public long getGradoGravedad() {
		return this.gradoGravedad;
	}

	public void setGradoGravedad(long gradoGravedad) {
		this.gradoGravedad = gradoGravedad;
	}

	public NombreEnfermedad getNombre() {
		return this.nombre;
	}

	public void setNombre(NombreEnfermedad nombre) {
		this.nombre = nombre;
	}

	public List<EnfermedadTernera> getEnfermedadTerneras() {
		return this.enfermedadTerneras;
	}

	public void setEnfermedadTerneras(List<EnfermedadTernera> enfermedadTerneras) {
		this.enfermedadTerneras = enfermedadTerneras;
	}

	public EnfermedadTernera addEnfermedadTernera(EnfermedadTernera enfermedadTernera) {
		getEnfermedadTerneras().add(enfermedadTernera);
		enfermedadTernera.setEnfermedad(this);

		return enfermedadTernera;
	}

	public EnfermedadTernera removeEnfermedadTernera(EnfermedadTernera enfermedadTernera) {
		getEnfermedadTerneras().remove(enfermedadTernera);
		enfermedadTernera.setEnfermedad(null);

		return enfermedadTernera;
	}
	public String toString(){
		return "Activity{ "+ 
				"converted= "+nombre+" }";
	}

}