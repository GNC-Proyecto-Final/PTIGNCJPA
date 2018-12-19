package entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MEDICAMENTOS database table.
 * 
 */
@Entity
@Table(name="MEDICAMENTOS")
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICAMENTOS_IDMEDICAMENTO_GENERATOR", sequenceName="SEQ_MEDICAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAMENTOS_IDMEDICAMENTO_GENERATOR")
	@Column(name="ID_MEDICAMENTO")
	private long idMedicamento;

	private String costo;

	private String dosis;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="America/Montevideo") 
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="America/Montevideo") 
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;

	private String nombre;

	//bi-directional many-to-one association to ConsumoMedicamentoTernera
	@JsonIgnore
	@OneToMany(mappedBy="medicamento")
	private List<ConsumoMedicamentoTernera> consumoMedicamentoTerneras;

	public Medicamento() {
	}

	public long getIdMedicamento() {
		return this.idMedicamento;
	}

	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getCosto() {
		return this.costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDosis() {
		return this.dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ConsumoMedicamentoTernera> getConsumoMedicamentoTerneras() {
		return this.consumoMedicamentoTerneras;
	}

	public void setConsumoMedicamentoTerneras(List<ConsumoMedicamentoTernera> consumoMedicamentoTerneras) {
		this.consumoMedicamentoTerneras = consumoMedicamentoTerneras;
	}

	public ConsumoMedicamentoTernera addConsumoMedicamentoTernera(ConsumoMedicamentoTernera consumoMedicamentoTernera) {
		getConsumoMedicamentoTerneras().add(consumoMedicamentoTernera);
		consumoMedicamentoTernera.setMedicamento(this);

		return consumoMedicamentoTernera;
	}

	public ConsumoMedicamentoTernera removeConsumoMedicamentoTernera(ConsumoMedicamentoTernera consumoMedicamentoTernera) {
		getConsumoMedicamentoTerneras().remove(consumoMedicamentoTernera);
		consumoMedicamentoTernera.setMedicamento(null);

		return consumoMedicamentoTernera;
	}

}