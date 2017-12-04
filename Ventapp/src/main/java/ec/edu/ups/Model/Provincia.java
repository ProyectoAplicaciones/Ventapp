package ec.edu.ups.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
//@Table(name="tbl_provincia")
public class Provincia implements Serializable {
	
	@Id
	@Column (name="prov_codigo", length=10)
	private int codigo;
	
	
	@NotNull
	@Column (name="prov_nombre")
	@Size(min=4,max=20)
	private String nombre;
	
	
	@Column (name="prov_alias", length=3)
	private String alias;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//cedula como se va a llamar en la otra tabla, el id de la tabla donde se crea
	@JoinColumn(name="id", referencedColumnName="prov_codigo")
	private List<Sector> sectores;
	
	
	public void addSector(Sector sector){
		if (sectores == null){
			sectores = new ArrayList<>();
			sectores.add(sector);
			
		}
	}


	@Override
	public String toString() {
		return "Provincia [codigo=" + codigo + ", nombre=" + nombre + ", alias=" + alias + ", sectores=" + sectores
				+ "]";
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public List<Sector> getSectores() {
		return sectores;
	}


	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

	
		

}//fin clase practia
