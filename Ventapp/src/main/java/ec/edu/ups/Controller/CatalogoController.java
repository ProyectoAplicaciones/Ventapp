package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.Dao.CatalogoDAO;
import ec.edu.ups.Model.Catalogo;

public class CatalogoController {

	private Catalogo catalogo;
	private List<Catalogo> catalogos;
	private String id;
	
	@Inject
	private CatalogoDAO cDAO;
	
	@Inject
    private FacesContext facesContext;
	
	@PostConstruct
	public void init() {
		catalogo = new Catalogo();
		loadcatalogos();
	}
	
	public String loadDatosEditar(String nombre) {
		catalogo = cDAO.leer(nombre);
		return "crearcatalogo"; //Llama a la pagina para que cargue el objeto persona cargado
	}
	
	public Catalogo getcatalogo() {
		return catalogo;
	}

	public void setcatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public List<Catalogo> getcatalogos() {
		return catalogos;
	}

	public void setcatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		loadDatosEditar(id);
		this.id = id;
	}

	@Override
	public String toString() {
		return "catalogoController [catalogo=" + catalogo + ", catalogos=" + catalogos + ", id=" + id + ", cDAO=" + cDAO + "]";
	}
	
	public String eliminar(String nombre) {//ActionController
		System.out.println(toString());
		try{
			cDAO.borrar(nombre);
			loadcatalogos();
		}catch(Exception e){
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Error al eliminar catalogo especificada.");
            facesContext.addMessage(null, m);
		}
		return "listadocatalogos";
	}
	
	public String guardar() {//ActionController
		System.out.println(toString());
		
		try{
			if (this.id!=null){
				cDAO.insertar(catalogo);
			}else{
				cDAO.actualizar(catalogo);
			}
			loadcatalogos();
		}catch(Exception e){
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "No se pudo guardar.");
            facesContext.addMessage(null, m);
		}
		loadcatalogos();
		return "listadocatalogos";
	}
	
	private void loadcatalogos() {
		catalogos=cDAO.listadoCatalogos();
	}
	
	private String getRootErrorMessage(Exception e) {
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            return errorMessage;
        }
        Throwable t = e;
        while (t != null) {
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        return errorMessage;
    }
	
}
