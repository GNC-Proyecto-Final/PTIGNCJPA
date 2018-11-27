package entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the UNIDADES database table.
 * 
 */
@Entity
@Table(name="UNIDADES")
@NamedQuery(name="Unidad.findAll", query="SELECT u FROM Unidad u")
public class Unidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADES_IDUNIDAD_GENERATOR", sequenceName="SEQ_UNIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADES_IDUNIDAD_GENERATOR")
	@Column(name="ID_UNIDAD")
	private long idUnidad;

	private String unidad;

	//bi-directional many-to-one association to Alimento
	@JsonIgnore
	@OneToMany(mappedBy="unidade")
	private List<Alimento> alimentos;

	public Unidad() {
	}

	public long getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public List<Alimento> getAlimentos() {
		return this.alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public Alimento addAlimento(Alimento alimento) {
		getAlimentos().add(alimento);
		alimento.setUnidade(this);

		return alimento;
	}

	public Alimento removeAlimento(Alimento alimento) {
		getAlimentos().remove(alimento);
		alimento.setUnidade(null);

		return alimento;
	}

}