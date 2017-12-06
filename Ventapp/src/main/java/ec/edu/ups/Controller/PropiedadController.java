package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import ec.edu.ups.Dao.PropiedadDao;
import ec.edu.ups.Model.Propiedad;

@ManagedBean
@javax.faces.bean.RequestScoped
public class PropiedadController {
	
	private Propiedad propiedad;
	private List<Propiedad> listpropiedades;
	private int id;
	
	@Inject
	private PropiedadDao propiedadDao;
	
	
	@PostConstruct
	public void init() {
		propiedad =new Propiedad();
		loadPropiedades();
	}

	
	public String guardar() {
		System.out.println(toString());
		
		System.out.println("datos "+propiedad);
		propiedadDao.guardar(propiedad);
		
		propiedad =new Propiedad();
		return null;
		
		
	}
	
	public String eliminar(int codigo) {
		System.out.println(toString());
		
			try {
				
				propiedadDao.eliminar(codigo);
				loadPropiedades();
				
			}
			catch (Exception e) {
				System.out.println("EERORRORO");
				
			}
		
		
		return"listarPropiedades";
	}
	
	public String editar() {
	
		
		propiedadDao.actualizar(propiedad);
			
		
			loadPropiedades();
		
			
		
		return "listarPropiedades";
	
	
	}
	
	public String loadDatosEditar(int codigo) {
		
		propiedad =propiedadDao.leer(codigo);
		return"EditarPropiedad";
	}
	
	public void setId(int id) {
		this.id = id;	
	loadDatosEditar(id);
	}
	
	
	public int getId() {
		return id;
	}


	


	public List<Propiedad> getListpropiedades() {
		return listpropiedades;
	}


	public void setListpropiedades(List<Propiedad> listpropiedades) {
		this.listpropiedades = listpropiedades;
	}


	


	public Propiedad getPropiedad() {
		return propiedad;
	}


	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	
	private void loadPropiedades() {
		
	listpropiedades=propiedadDao.listadoPropiedades();
	}
	
	
	



	
	
	
}
