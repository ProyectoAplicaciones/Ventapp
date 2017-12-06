package ec.edu.ups.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Imagen")
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoImagen;
	
	@Size(min=1, max=100)
	@Column(unique=true)
	private String nombreImagen;
	
	@Size(min=1, max=100)
	private String descripcionImagen;
	
	@NotNull
	@NotEmpty
	private String pathImagen;

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	
	public int getCodigoImagen() {
		return codigoImagen;
	}

	public void setCodigoImagen(int codigoImagen) {
		this.codigoImagen = codigoImagen;
	}

	public String getDescripcionImagen() {
		return descripcionImagen;
	}

	public void setDescripcionImagen(String descripcionImagen) {
		this.descripcionImagen = descripcionImagen;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	
}