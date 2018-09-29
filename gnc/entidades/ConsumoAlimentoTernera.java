package entidades;

import java.io.Serializable;
import javax.persistence.*;



import java.math.BigDecimal;


/**
 * The persistent class for the CONSUMO_ALIMENTO_TERNERAS database table.
 * 
 */


@Entity
@IdClass(ConsumoAlimentoTerneraPK.class)
@Table(name="CONSUMO_ALIMENTO_TERNERAS")
@NamedQueries({
@NamedQuery(name="ConsumoAlimentoTernera.findAll", query="SELECT c FROM ConsumoAlimentoTernera c")
}) 
public class ConsumoAlimentoTernera implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@EmbeddedId
	private ConsumoAlimentoTerneraPK id;*/

	@Id
	@Column(name="ID_ALIMENTO")
	private long idAlimento;
	
	@Id
	@Column(name="ID_TERNERA")
	private long idTernera;
	
	@Id
	private java.util.Date fecha;
	
	private BigDecimal cantidad;

	//bi-directional many-to-one association to Alimento
	@ManyToOne
	@JoinColumn(name="ID_ALIMENTO",referencedColumnName="ID_ALIMENTO")
	private Alimento alimento;

	//bi-directional many-to-one association to Ternera
	@ManyToOne
	@JoinColumn(name="ID_TERNERA",referencedColumnName="ID_TERNERA")
	private Ternera ternera;

	public ConsumoAlimentoTernera() {
	}
/*
	public ConsumoAlimentoTerneraPK getId() {
		return this.id;
	}

	public void setId(ConsumoAlimentoTerneraPK id) {
		this.id = id;
	}
*/
	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Alimento getAlimento() {
		return this.alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public Ternera getTernera() {
		return this.ternera;
	}

	public void setTernera(Ternera ternera) {
		this.ternera = ternera;
	}

}