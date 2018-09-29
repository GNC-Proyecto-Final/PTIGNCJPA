package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The primary key class for the ENFERMEDAD_TERNERA database table.
 * 
 */
@Embeddable
public class EnfermedadTerneraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_TERNERA")
	private long idTernera;

	@Column(name="ID_ENFERMEDAD")
	private long idEnfermedad;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	public EnfermedadTerneraPK() {
	}
	public long getIdTernera() {
		return this.idTernera;
	}
	public void setIdTernera(long idTernera) {
		this.idTernera = idTernera;
	}
	public long getIdEnfermedad() {
		return this.idEnfermedad;
	}
	public void setIdEnfermedad(long idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}
	public java.util.Date getFechaDesde() {
		return this.fechaDesde;
	}
	public void setFechaDesde(java.util.Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnfermedadTerneraPK)) {
			return false;
		}
		EnfermedadTerneraPK castOther = (EnfermedadTerneraPK)other;
		return 
			(this.idTernera == castOther.idTernera)
			&& (this.idEnfermedad == castOther.idEnfermedad)
			&& this.fechaDesde.equals(castOther.fechaDesde);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idTernera ^ (this.idTernera >>> 32)));
		hash = hash * prime + ((int) (this.idEnfermedad ^ (this.idEnfermedad >>> 32)));
		hash = hash * prime + this.fechaDesde.hashCode();
		
		return hash;
	}
}