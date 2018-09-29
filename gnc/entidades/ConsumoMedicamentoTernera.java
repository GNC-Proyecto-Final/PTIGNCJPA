package entidades;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigDecimal;


/**
 * The persistent class for the CONSUMO_MEDICAMENTO_TERNERA database table.
 * 
 */
@Entity
@IdClass(ConsumoMedicamentoTerneraPK.class)
@Table(name="CONSUMO_MEDICAMENTO_TERNERA")
@NamedQuery(name="ConsumoMedicamentoTernera.findAll", query="SELECT c FROM ConsumoMedicamentoTernera c")
public class ConsumoMedicamentoTernera implements Serializable {
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	/*@Id
	private ConsumoMedicamentoTerneraPK id;*/

	@Id
	@Column(name="ID_MEDICAMENTO")
	private long idMedicamento;
	
	@Id
	@Column(name="ID_TERNERA")
	private long idTernera;
	
	@Id
	private java.util.Date fecha;
	
	private BigDecimal cantidad;

	//bi-directional many-to-one association to Medicamento
	
	//
	
	@ManyToOne
	@JoinColumn(name="ID_MEDICAMENTO",referencedColumnName="ID_MEDICAMENTO")
	private Medicamento medicamento;

	//bi-directional many-to-one association to Ternera
	
	//
	@ManyToOne
	@JoinColumn(name="ID_TERNERA",referencedColumnName="ID_TERNERA")
	private Ternera ternera;

	public ConsumoMedicamentoTernera() {
	}

	/*public ConsumoMedicamentoTerneraPK getId() {
		return this.id;
	}

	public void setId(ConsumoMedicamentoTerneraPK id) {
		this.id = id;
	}*/

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Ternera getTernera() {
		return this.ternera;
	}

	public void setTernera(Ternera ternera) {
		this.ternera = ternera;
	}

}