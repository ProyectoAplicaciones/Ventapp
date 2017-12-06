
package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.Dao.ContactoDao;
import ec.edu.ups.Model.Contactos;
import ec.edu.ups.Model.Persona;

@ManagedBean
public class ContactoController {

	private Contactos contacto;
	
	@Inject
	private ContactoDao contactoDao;
	private List<Contactos> contactos; 
	private String id; 
	
	@PostConstruct
	public void Int() {
		contacto = new Contactos();
		loadContacto();
	}

	
	public Contactos getContacto() {
		return contacto;
	}

	public void setContacto(Contactos contacto) {
		this.contacto = contacto;
	}

	public List<Contactos> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contactos> contactos) {
		this.contactos = contactos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String guardar() {
		System.err.println(contacto);
		try {
		contactoDao.guardar(contacto);
		}catch(Exception e){
			
		}
		return null;
	}
	
	public String guardarEdicion() {
		System.err.println(contacto);		
				contactoDao.actualizar(contacto);
		return null;
	}
	
	public void loadContacto() {
		contactos =  contactoDao.listarContacto();
	}
	
	public String loadDatosEditar(int codigo) {
		contacto = contactoDao.leer(codigo);
		return "editarContacto";
	}
	
	public String eliminarDatos(int codigo) {
		try {
			contactoDao.eliminar(codigo);
			loadContacto();
		} catch (Exception e) {
			
		}
		return null; 
	}
	
}

