package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Sector;




@Stateless
public class SectorDAO {

	@Inject
	EntityManager em;
	
	/**
	 * Metodo para insertar datos del objeto Sector
	 * @param nin
	 */
	public void insertar(Sector sec){
		em.persist(sec);
	}
	
	/**
	 * Metodo para actualizar datos del objeto Sector
	 * @param nin
	 */
	public void actualizar(Sector sec){
		em.merge(sec);
	}
	
	/**
	 * Metodo para borrar un registro del objeto Sector
	 * @param id
	 */
	public void borrar(int id){
		Sector nin = em.find(Sector.class, id);
		em.remove(nin);
	}
	
	/**
	 * Metodo para guardar un nuevo registro del objeto Sector o actualizar un registro
	 * @param nin
	 */
	public void save(Sector nin){
		if(em.find(Sector.class, nin.getId())==null)
			insertar(nin);
		else
			actualizar(nin);
	}
	
	/**
	 * Meodo para obtener una lista de los niños
	 * @return
	 */
	public List<Sector> getSectores(){
		String sql = "SELECT n FROM Sector n";
		Query q =em.createQuery(sql,Sector.class );
		List<Sector> sectores = q.getResultList();
		return sectores;
	}
	
	/**
	 * Metodo para obtener los datos de un niño en especifico segun su id
	 * @param id
	 * @return
	 */
	public Sector getSector(int id){
		return em.find(Sector.class,id);
	}
}
