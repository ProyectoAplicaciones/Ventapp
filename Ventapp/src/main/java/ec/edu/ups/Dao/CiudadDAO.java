package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.Model.Ciudad;


@Stateless
public class CiudadDAO {
	
	@Inject
	EntityManager em;
	
	public void insertar(Ciudad ciudad){
		em.persist(ciudad);
	}
	
	public Ciudad leer(String nombre) {
		Ciudad c = em.find(Ciudad.class, nombre);
		return c;
	}
	
	public void actualizar(Ciudad ciudad){
		em.merge(ciudad);
	}
	
	public void borrar(String nombre){
		em.remove(leer(nombre));
	}
	
	public void guardar(Ciudad ciudad){
		Ciudad c = leer(ciudad.getNombreCiudad());
		if(c==null)
			insertar(ciudad);
		else
			actualizar(ciudad);
	}
	
	public List<Ciudad> getCiudades(){
		String sql = "SELECT n FROM Ciudad n";
		Query q =em.createQuery(sql,Ciudad.class );
		List<Ciudad> ciudades = q.getResultList();
		return ciudades;
	}
	
}
