package ec.edu.ups.Controller;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.Email;

import ec.edu.ups.Dao.PersonaDao;
import ec.edu.ups.Model.Persona;


@ManagedBean
@SessionScoped
public class Login {
	
	
	
	private Persona persona;
	//@Email
	private  String email;
	private String pass;
	
	
	
	
	@Inject
	private PersonaDao personaDao;
	
	@PostConstruct
	private void init(){
		persona = new Persona();
	}
	


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String submit () {
		
		System.out.println("entro");
				 persona = personaDao.buscarUser(this.getEmail(),this.getPass());
				 
				 if(persona != null)
	 			{
				System.out.println("redireccion");
				return"crearContacto.xhtml";
	 			}
		
			
		return "#";
	}
}


