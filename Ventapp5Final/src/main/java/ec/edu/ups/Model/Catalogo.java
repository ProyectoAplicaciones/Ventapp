package ec.edu.ups.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="Catalogo")
public class Catalogo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoCatalogo;
	
	@Size(min=1, max=100)
	private String descripcionCatalogo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaInicioCatalogo")
	private Date FechaInicioCatalogo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaFinCatalogo")
	private Date FechaFinCatalogo;
	
	public int getCodigoCatalogo() {
		return codigoCatalogo;
	}

	public void setCodigoCatalogo(int codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}

	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}

	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}

	public Date getFechaInicioCatalogo() {
		return FechaInicioCatalogo;
	}

	public void setFechaInicioCatalogo(Date fechaInicioCatalogo) {
		FechaInicioCatalogo = fechaInicioCatalogo;
	}

	public Date getFechaFinCatalogo() {
		return FechaFinCatalogo;
	}

	public void setFechaFinCatalogo(Date fechaFinCatalogo) {
		FechaFinCatalogo = fechaFinCatalogo;
	}

	public String getEstadoCatalogo() {
		return estadoCatalogo;
	}

	public void setEstadoCatalogo(String estadoCatalogo) {
		this.estadoCatalogo = estadoCatalogo;
	}

	@Column(name="estadoCatalogo",length=1)
	private String estadoCatalogo; 
	
}