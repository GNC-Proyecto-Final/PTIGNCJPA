package entidades;

import java.io.Serializable;
import javax.persistence.*;
import enumerados.Raza;
import enumerados.TipoParto;
import enumerados.convert.RazaConvert;
import enumerados.convert.TipoPartoConvert;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 				consultaTerneraIdTernera = DatabaseManager.getConnection().prepareStatement("SELECT * FROM TERNERAS WHERE ID_TERNERA=?");	
				consultaTerneraNroCaravana = DatabaseManager.getConnection().prepareStatement("SELECT * FROM TERNERAS WHERE NRO_CARAVANA=?");	 
 */
/**
 * The persistent class for the TERNERAS database table.
 * 
 */
@Entity
@Table(name="TERNERAS")
@NamedQueries({
@NamedQuery(name="Ternera.obtenerTodasTerneras", query="SELECT t FROM Ternera t"),
@NamedQuery(name="Ternera.obtenerTerneraNroCaravana", query="SELECT t FROM Ternera t WHERE t.nroCaravana = :nroCaravana"),
@NamedQuery(name="Ternera.obtenerTerneraId", query="SELECT t FROM Ternera t WHERE t.idTernera LIKE :idTernera")
})
public class Ternera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TERNERAS_IDTERNERA_GENERATOR", sequenceName="SEQ_TERNERA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TERNERAS_IDTERNERA_GENERATOR")
	@Column(name="ID_TERNERA")
	private long idTernera;

	@Column(name="CAUSA_BAJA")
	private String causaBaja;

	@Column(name="CAUSA_MUERTE")
	private String causaMuerte;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_BAJA")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_MUERTE")
	private Date fechaMuerte;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name="NRO_CARAVANA")
	private long nroCaravana;

	@Convert(converter = TipoPartoConvert.class)
	private TipoParto parto;

	@Column(name="PESO_NACIMIENTO")
	private BigDecimal pesoNacimiento;

	@Convert(converter = RazaConvert.class)
	private Raza raza;

	//bi-directional many-to-one association to ConsumoAlimentoTernera
	@OneToMany(mappedBy="ternera")
	private List<ConsumoAlimentoTernera> consumoAlimentoTerneras;

	//bi-directional many-to-one association to ConsumoMedicamentoTernera
	@OneToMany(mappedBy="ternera")
	private List<ConsumoMedicamentoTernera> consumoMedicamentoTerneras;

	//bi-directional many-to-one association to EnfermedadTernera
	@OneToMany(mappedBy="ternera")
	private List<EnfermedadTernera> enfermedadTerneras;

	//bi-directional many-to-one association to Peso
	@OneToMany(mappedBy="ternera")
	private List<Peso> pesos;

	//bi-directional many-to-one association to Guachera
	@ManyToOne
	@JoinColumn(name="ID_GUACHERA")
	private Guachera guachera;

	//bi-directional many-to-one association to Madre
	@ManyToOne
	@JoinColumn(name="ID_MADRE")
	private Madre madre;

	//bi-directional many-to-one association to Padre
	@ManyToOne
	@JoinColumn(name="ID_PADRE")
	private Padre padre;

	public Ternera() {
	}

	public long getIdTernera() {
		return this.idTernera;
	}

	public void setIdTernera(long idTernera) {
		this.idTernera = idTernera;
	}

	public String getCausaBaja() {
		return this.causaBaja;
	}

	public void setCausaBaja(String causaBaja) {
		this.causaBaja = causaBaja;
	}

	public String getCausaMuerte() {
		return this.causaMuerte;
	}

	public void setCausaMuerte(String causaMuerte) {
		this.causaMuerte = causaMuerte;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaMuerte() {
		return this.fechaMuerte;
	}

	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getNroCaravana() {
		return this.nroCaravana;
	}

	public void setNroCaravana(long nroCaravana) {
		this.nroCaravana = nroCaravana;
	}

	public TipoParto getParto() {
		return this.parto;
	}

	public void setParto(TipoParto parto) {
		this.parto = parto;
	}

	public BigDecimal getPesoNacimiento() {
		return this.pesoNacimiento;
	}

	public void setPesoNacimiento(BigDecimal pesoNacimiento) {
		this.pesoNacimiento = pesoNacimiento;
	}

	public Raza getRaza() {
		return this.raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<ConsumoAlimentoTernera> getConsumoAlimentoTerneras() {
		return this.consumoAlimentoTerneras;
	}

	public void setConsumoAlimentoTerneras(List<ConsumoAlimentoTernera> consumoAlimentoTerneras) {
		this.consumoAlimentoTerneras = consumoAlimentoTerneras;
	}

	public ConsumoAlimentoTernera addConsumoAlimentoTernera(ConsumoAlimentoTernera consumoAlimentoTernera) {
		getConsumoAlimentoTerneras().add(consumoAlimentoTernera);
		consumoAlimentoTernera.setTernera(this);

		return consumoAlimentoTernera;
	}

	public ConsumoAlimentoTernera removeConsumoAlimentoTernera(ConsumoAlimentoTernera consumoAlimentoTernera) {
		getConsumoAlimentoTerneras().remove(consumoAlimentoTernera);
		consumoAlimentoTernera.setTernera(null);

		return consumoAlimentoTernera;
	}

	public List<ConsumoMedicamentoTernera> getConsumoMedicamentoTerneras() {
		return this.consumoMedicamentoTerneras;
	}

	public void setConsumoMedicamentoTerneras(List<ConsumoMedicamentoTernera> consumoMedicamentoTerneras) {
		this.consumoMedicamentoTerneras = consumoMedicamentoTerneras;
	}

	public ConsumoMedicamentoTernera addConsumoMedicamentoTernera(ConsumoMedicamentoTernera consumoMedicamentoTernera) {
		getConsumoMedicamentoTerneras().add(consumoMedicamentoTernera);
		consumoMedicamentoTernera.setTernera(this);

		return consumoMedicamentoTernera;
	}

	public ConsumoMedicamentoTernera removeConsumoMedicamentoTernera(ConsumoMedicamentoTernera consumoMedicamentoTernera) {
		getConsumoMedicamentoTerneras().remove(consumoMedicamentoTernera);
		consumoMedicamentoTernera.setTernera(null);

		return consumoMedicamentoTernera;
	}

	public List<EnfermedadTernera> getEnfermedadTerneras() {
		return this.enfermedadTerneras;
	}

	public void setEnfermedadTerneras(List<EnfermedadTernera> enfermedadTerneras) {
		this.enfermedadTerneras = enfermedadTerneras;
	}

	public EnfermedadTernera addEnfermedadTernera(EnfermedadTernera enfermedadTernera) {
		getEnfermedadTerneras().add(enfermedadTernera);
		enfermedadTernera.setTernera(this);

		return enfermedadTernera;
	}

	public EnfermedadTernera removeEnfermedadTernera(EnfermedadTernera enfermedadTernera) {
		getEnfermedadTerneras().remove(enfermedadTernera);
		enfermedadTernera.setTernera(null);

		return enfermedadTernera;
	}

	public List<Peso> getPesos() {
		return this.pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}

	public Peso addPeso(Peso peso) {
		getPesos().add(peso);
		peso.setTernera(this);

		return peso;
	}

	public Peso removePeso(Peso peso) {
		getPesos().remove(peso);
		peso.setTernera(null);

		return peso;
	}

	public Guachera getGuachera() {
		return this.guachera;
	}

	public void setGuachera(Guachera guachera) {
		this.guachera = guachera;
	}

	public Madre getMadre() {
		return this.madre;
	}

	public void setMadre(Madre madre) {
		this.madre = madre;
	}

	public Padre getPadre() {
		return this.padre;
	}

	public void setPadre(Padre padre) {
		this.padre = padre;
	}

}