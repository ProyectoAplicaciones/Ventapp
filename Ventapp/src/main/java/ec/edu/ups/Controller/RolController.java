package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.Dao.RolDao;
import ec.edu.ups.Model.Rol;
@ManagedBean
@RequestScoped
public class RolController {

	
	private Rol rol;
	private List<Rol> listRoles;
	private int id;
	
	@Inject
	private RolDao rolDao;
	
	
	@PostConstruct
	public void init() {
		rol =new Rol();
		loadRoles();
		
	}
	
	public String guardar() {
		System.out.println(toString());	
		rolDao.guardar(rol);
		rol =new Rol();
		
		return null;
	}
	
	public String eliminar(int codigo) {
		System.out.println(toString());
		
			try {
				
				rolDao.eliminar(codigo);
				loadRoles();
				
			}
			catch (Exception e) {
				System.out.println("EERORRORO");
				
			}
		
		
			return"Roles";
		}
	
	public String loadDatosEditar(int codigo) {
		
		rol =rolDao.leer(codigo);
		return"RolesEditar";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}

	public List<Rol> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Rol> listRoles) {
		this.listRoles = listRoles;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	private void loadRoles() {
		listRoles =rolDao.listadoRoles();
	}
	
}
