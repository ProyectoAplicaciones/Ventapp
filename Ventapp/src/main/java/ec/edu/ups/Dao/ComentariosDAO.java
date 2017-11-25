package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Comentarios;
import ec.edu.ups.Model.Sector;


@Stateless
public class ComentariosDAO {

	@Inject
	private EntityManager em;
	
	public void save(Comentarios comentarios){
		if(em.find(Comentarios.class, comentarios.getId())==null)
			insertar(comentarios);
		else
			actualizar(comentarios);
	}
	public void insertar(Comentarios comentarios){
		em.persist(comentarios);
	}
	
	public void actualizar(Comentarios comentarios){
		em.merge(comentarios);
	}
	
	public List<Comentarios> getComentarios(){
		String sql = "SELECT c FROM Comentarios c";
		Query q =em.createQuery(sql,Comentarios.class );
		List<Comentarios> comentarios = q.getResultList();
		
		return comentarios;
	}
	
	public Comentarios getComentario(int id){
		return em.find(Comentarios.class,id);
	}
	
	public void borrar(int id){
		Comentarios com = em.find(Comentarios.class, id);
		em.remove(com);
	}
	
	
}
