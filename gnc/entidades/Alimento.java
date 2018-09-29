package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ALIMENTOS database table.
 * 
 */
@Entity
@Table(name="ALIMENTOS")
@NamedQuery(name="Alimento.findAll", query="SELECT a FROM Alimento a")
public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALIMENTOS_IDALIMENTO_GENERATOR", sequenceName="SEQ_ALIMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALIMENTOS_IDALIMENTO_GENERATOR")
	@Column(name="ID_ALIMENTO")
	private long idAlimento;

	private BigDecimal cantidad;

	@Column(name="COSTO_UNIDAD")
	private BigDecimal costoUnidad;

	private String nombre;

	//bi-directional many-to-one association to Unidad
	@ManyToOne
	@JoinColumn(name="ID_UNIDAD")
	private Unidad unidade;

	//bi-directional many-to-one association to ConsumoAlimentoTernera
	@OneToMany(mappedBy="alimento")
	private List<ConsumoAlimentoTernera> consumoAlimentoTerneras;

	public Alimento() {
	}

	public long getIdAlimento() {
		return this.idAlimento;
	}

	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoUnidad() {
		return this.costoUnidad;
	}

	public void setCostoUnidad(BigDecimal costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Unidad getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidad unidade) {
		this.unidade = unidade;
	}

	public List<ConsumoAlimentoTernera> getConsumoAlimentoTerneras() {
		return this.consumoAlimentoTerneras;
	}

	public void setConsumoAlimentoTerneras(List<ConsumoAlimentoTernera> consumoAlimentoTerneras) {
		this.consumoAlimentoTerneras = consumoAlimentoTerneras;
	}

	public ConsumoAlimentoTernera addConsumoAlimentoTernera(ConsumoAlimentoTernera consumoAlimentoTernera) {
		getConsumoAlimentoTerneras().add(consumoAlimentoTernera);
		consumoAlimentoTernera.setAlimento(this);

		return consumoAlimentoTernera;
	}

	public ConsumoAlimentoTernera removeConsumoAlimentoTernera(ConsumoAlimentoTernera consumoAlimentoTernera) {
		getConsumoAlimentoTerneras().remove(consumoAlimentoTernera);
		consumoAlimentoTernera.setAlimento(null);

		return consumoAlimentoTernera;
	}

}