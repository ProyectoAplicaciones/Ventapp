package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.Dao.ComentariosDAO;
import ec.edu.ups.Dao.SectorDAO;
import ec.edu.ups.Model.Comentarios;
import ec.edu.ups.Model.Sector;


@ManagedBean
@SessionScoped
public class ComentarioController {
	
	private Comentarios com;
	
	//Lista de ninos
	private List<Comentarios> listComentarios;
	
	@Inject
	private ComentariosDAO comDao;
	
	@PostConstruct
	public void init(){
		com = new Comentarios();
		listComentarios = comDao.getComentarios();
	}


	public Comentarios getCom() {
		return com;
	}


	public void setCom(Comentarios com) {
		this.com = com;
	}

	public List<Comentarios> getListComentarios() {
		return listComentarios;
	}


	public void setListComentarios(List<Comentarios> listComentarios) {
		this.listComentarios = listComentarios;
	}

	public ComentariosDAO getComDao() {
		return comDao;
	}

	public void setComDao(ComentariosDAO comDao) {
		this.comDao = comDao;
	}


	/**
	 * Metodo para guardar un nuevo registro de un Comentario
	 * @return
	 */
	public String guardarComentario(){
		comDao.save(com);
		init();
		return null;
	}
	
	/**
	 * Meto para elminar un registro del objeto Sector
	 * @param id para identificar que registro eliminar
	 * @return
	 */
	public String eliminarComentario(int id){
		comDao.borrar(id);
		init();
		return null;
	}
	
	/**
	 * Metodo para actualizar los datos de un niño
	 * @param id identifica que registro de niño quiere actualizar 
	 * @return
	 */
	public String actualizarComentario(int id){
		 Comentarios com = comDao.getComentario(id);
		 this.com=com;
		return null;
	}

}
