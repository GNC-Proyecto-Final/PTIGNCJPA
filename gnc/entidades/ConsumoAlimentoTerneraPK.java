package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONSUMO_ALIMENTO_TERNERAS database table.
 * 
 */
@Embeddable
public class ConsumoAlimentoTerneraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_TERNERA", insertable=false, updatable=false)
	private long idTernera;

	@Column(name="ID_ALIMENTO", insertable=false, updatable=false)
	private long idAlimento;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	public ConsumoAlimentoTerneraPK() {
	}
	public long getIdTernera() {
		return this.idTernera;
	}
	public void setIdTernera(long idTernera) {
		this.idTernera = idTernera;
	}
	public long getIdAlimento() {
		return this.idAlimento;
	}
	public void setIdAlimento(long idAlimento) {
		this.idAlimento = idAlimento;
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
		if (!(other instanceof ConsumoAlimentoTerneraPK)) {
			return false;
		}
		ConsumoAlimentoTerneraPK castOther = (ConsumoAlimentoTerneraPK)other;
		return 
			(this.idTernera == castOther.idTernera)
			&& (this.idAlimento == castOther.idAlimento)
			&& this.fecha.equals(castOther.fecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idTernera ^ (this.idTernera >>> 32)));
		hash = hash * prime + ((int) (this.idAlimento ^ (this.idAlimento >>> 32)));
		hash = hash * prime + this.fecha.hashCode();
		
		return hash;
	}
}