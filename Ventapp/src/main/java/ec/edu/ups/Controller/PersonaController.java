package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.Dao.PersonaDao;
import ec.edu.ups.Model.Persona;
import ec.edu.ups.Model.telefono;

@ManagedBean
public class PersonaController {

	private Persona persona;
	
	@Inject
	private PersonaDao personaDao;
	
	private List<Persona> personas; 
	private String id; 
	
	@PostConstruct
	public void Int() {
		persona = new Persona();
		loadPersona();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String guardar() {
		System.err.println(persona);
		try {
		personaDao.guardar(persona);
		return "index.xhtml";
		}catch(Exception e){
			
		}
		return null;
	}
	
	public String guardarEdicion() {
		System.err.println(persona);
		
			
				personaDao.actualizar(persona);
			
		
		return null;
	}
	
	public void loadPersona() {
		personas = personaDao.listarPersona();
	}
	public String loadDatosEditar(int codigo) {
		persona = personaDao.leer(codigo);
		return null;
	}
	
	public String eliminarDatos(int codigo) {
		try {
			personaDao.eliminar(codigo);
			loadPersona();
		} catch (Exception e) {
			
		}
		return null; 
	}
	

}
