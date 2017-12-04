package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.print.attribute.standard.PDLOverrideSupported;

import Modelo.Persona;
import Modelo.Telefono;
import ec.edu.ups.Dao.CiudadDAO;
import ec.edu.ups.Model.Ciudad;

@ManagedBean
public class CiudadController {

	private Ciudad ciudad;
	private List<Ciudad> ciudades;
	private String id;
	
	@Inject
	private CiudadDAO cDAO;
	
	@PostConstruct
	public void init() {
		ciudad = new Ciudad();
		loadCiudades();
	}
	
	public String loadDatosEditar(String cedula) {
		ciudad = cDAO.leer(cedula);
		return "crearciudad"; //Llama a la pagina para que cargue el objeto persona cargado
	}
	
	private void loadCiudades() {
		ciudades=cDAO.listadoCiudades();
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CiudadController [ciudad=" + ciudad + ", ciudades=" + ciudades + ", id=" + id + ", cDAO=" + cDAO + "]";
	}
	
	public String eliminar(String nombre) {//ActionController
		System.out.println(toString());
		try{
			cDAO.borrar(nombre);
			loadCiudades();
		}catch(Exception e){
			e.getMessage();
		}
		return "listadoCiudades";
	}
	
	public String guardar() {//ActionController
		System.out.println(toString());
		try{
			cDAO.guardar(ciudad);
		}catch(Exception e){
			e.getMessage();
		}
		loadCiudades();
		return "null";
	}
	
	
	
}
