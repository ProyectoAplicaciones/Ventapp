package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.Dao.ProvinciaDAO;
import ec.edu.ups.Model.Provincia;
import ec.edu.ups.Model.Sector;



@ManagedBean
@ViewScoped
public class ProvinciaControlador {
	
	@Inject
	private ProvinciaDAO pdao;
	
	private Provincia provincia = null;
	
	private List<Provincia> provincias;
	
	private int id;
	
	@PostConstruct
	public void init(){
		provincia = new Provincia();
		loadProvincias();
		
		
		provincia.addSector(new Sector());
		
	}

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
		
		loadDatosEditar(id);////con parametros
		
	}
	
	
	
	
	public ProvinciaDAO getPdao() {
		return pdao;
	}


	public void setPdao(ProvinciaDAO pdao) {
		this.pdao = pdao;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public List<Provincia> getProvincias() {
		return provincias;
	}


	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}


	public void loadProvincias(){
		
		provincias = pdao.listaProvincias();
		
	}
	
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de personas a editar" + id);
		provincia = pdao.leer(id);
		return "mantenimientoSector";
		
		
	}
	
   public String eliminarDatos(int id){
		
		
	   
	   pdao.borrar(id);
		return null;
		
	}//eliminar
   
   /*public String eliminarSector(Sector sec){
	   
	   try {
			if(this.id!=0) {
				System.out.println("hola entro a eliminar");
				provincia.getSectores().remove(sec);
				
			}else
				provincia.getSectores().remove(sec);
		}catch (Exception e) {
			
		}
	   
		return null;
		
	}//eliminar

	*/
	public String guardar(){
		
		System.out.println("guardando Provincia "+provincia);
		
		pdao.guardar(provincia);
		loadProvincias();
		
		return "listadoProvincia";
	}
	
	public String agregaSector(){
		provincia.getSectores().add(new Sector());
		return null;
	}
}//fin clase PersonaControlador
