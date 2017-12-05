package ec.edu.ups.Model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Propiedades")
public class Propiedad {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	

	@Size(min=1, max=50)
	private String direccion;
	
	//@NotEmpty
	private String urlVideo;
	
	@Size(min=1, max=50)
	//@NotEmpty
	private String descripcion;
	
	//@NotEmpty
	private String estado;
	
	//@NotEmpty
	private String tipo;
	
	//@NotEmpty
	private String costo;
	
	private float longuitud;
	private float latitud;
	
	

	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER) //como se llama el fk en la tabla hija el campo que se add 
	//como se llama el campo que se relaciona 
@JoinColumn(name ="comentarios", referencedColumnName="codigo")
private List<Comentarios> comentarios;

	
	
	


	public List<Comentarios> getComentarios() {
		return comentarios;
	}




	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
		
	}




	public int getCodigo() {
		return codigo;
	}




	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}




	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getUrlVideo() {
		return urlVideo;
	}


	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getCosto() {
		return costo;
	}


	public void setCosto(String costo) {
		this.costo = costo;
	}


	public float getLonguitud() {
		return longuitud;
	}


	public void setLonguitud(float longuitud) {
		this.longuitud = longuitud;
	}


	public float getLatitud() {
		return latitud;
	}


	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}


	public void addcomentario(Comentarios comentario) {
		if(comentarios==null)
			comentarios=new ArrayList<>();
		comentarios.add(comentario);
	}


	
	
}
