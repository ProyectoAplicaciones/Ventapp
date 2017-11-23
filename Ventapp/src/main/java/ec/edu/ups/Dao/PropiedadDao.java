package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Propiedad;



@Stateless
public class PropiedadDao {
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Propiedad propiedad) {
		Propiedad p =leer(propiedad.getCodigo());
		
		System.out.println(propiedad.getCodigo());
		if(p==null)
			insertar(propiedad);
		else
			actualizar(propiedad);
	
	}	
	
	
	public void insertar(Propiedad propiedad) {	
		em.persist(propiedad);
	}
	
	
	public void actualizar(Propiedad propiedad) {
		em.merge(propiedad);
	}

	
	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Propiedad leer(int codigo) {
		Propiedad p =em.find(Propiedad.class, codigo);
		
		return p;
	}
	
	public List<Propiedad> listadoPropiedades(){
		String jpql = "Select p From Propiedad p";// p es un alias
		Query query = em.createQuery(jpql,Propiedad.class);
		List<Propiedad> listado = query.getResultList();
		
		
		System.out.println(listado.size());
		return listado;
		
	}
	
}
