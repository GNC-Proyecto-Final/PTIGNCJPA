package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONSUMO_MEDICAMENTO_TERNERA database table.
 * 
 */
@Embeddable
public class ConsumoMedicamentoTerneraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_TERNERA", insertable=false, updatable=false)
	private long idTernera;

	@Column(name="ID_MEDICAMENTO", insertable=false, updatable=false)
	private long idMedicamento;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	public ConsumoMedicamentoTerneraPK() {
	}
	public long getIdTernera() {
		return this.idTernera;
	}
	public void setIdTernera(long idTernera) {
		this.idTernera = idTernera;
	}
	public long getIdMedicamento() {
		return this.idMedicamento;
	}
	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsumoMedicamentoTerneraPK)) {
			return false;
		}
		ConsumoMedicamentoTerneraPK castOther = (ConsumoMedicamentoTerneraPK)other;
		return 
			(this.idTernera == castOther.idTernera)
			&& (this.idMedicamento == castOther.idMedicamento)
			&& this.fecha.equals(castOther.fecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idTernera ^ (this.idTernera >>> 32)));
		hash = hash * prime + ((int) (this.idMedicamento ^ (this.idMedicamento >>> 32)));
		hash = hash * prime + this.fecha.hashCode();
		
		return hash;
	}
}