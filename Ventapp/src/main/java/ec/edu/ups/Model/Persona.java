package ec.edu.ups.Model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//@ManagedBean
@Entity
public class Persona {

	//crear variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="per_codigo",length=10)
	private int codigo;
	

	@Size(min=3,max=10)
	private String nombre;
	

	@Size(min=3,max=10)

	private String apellido;
	

	@Size(min=4,max=50)
	private String direccion;
	
	
	@Column(name="per_email")

	private String email;
	

	private String password;
	
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", email=" + email + ", password=" + password + ", telefonos=" +  "]";
	}
	
	
	
	
}
