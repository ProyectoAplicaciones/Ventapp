package ec.edu.ups.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

	
	@Id
	private int codigo;
	private String descripcion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
