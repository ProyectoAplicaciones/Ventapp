package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Persona;

@Stateless
public class PersonaDao {

	@Inject
	private EntityManager em;
	
	public void guardar (Persona persona) {
		
		Persona p =leer(persona.getCodigo());
		
		if(p==null)
			insertar(persona);
		else
			actualizar(persona);
	}
	
	public void insertar(Persona persona) {
		em.persist(persona);
	}
	
	public void actualizar (Persona persona) {
		em.merge(persona);
	}
	
	public void eliminar (int codigo) {
		em.remove(leer(codigo));
	}
	
	public Persona leer (int codigo) {
		Persona p = em.find(Persona.class, codigo);
		return p;
	}
	
	public List<Persona> listarPersona(){
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		List<Persona> list = query.getResultList();
		return list;
	}
	
	public void guardaPersona(Persona per) {
		Persona p = leer(per.getCodigo());
		if(p==null) {
			guardaPersona(per);
		}else {
			actualizar(per);
		}
	}
}
