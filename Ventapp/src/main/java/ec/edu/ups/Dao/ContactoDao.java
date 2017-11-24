package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Contactos;
import ec.edu.ups.Model.Persona;

@Stateless
public class ContactoDao {

	@Inject
	private EntityManager em;
	
	public void insertar(Contactos contactos) {
		em.persist(contactos);
	}
	
	public void actualizar (Contactos contactos) {
		em.merge(contactos);
	}
	
	public void eliminar (int codigo) {
		em.remove(leer(codigo));
	}
	
	public Contactos leer (int codigo) {
		Contactos c = em.find(Contactos.class, codigo);
		System.out.println("codigo "+codigo+" datos "+c);
		return c;
	}
	
	public void guardar (Contactos contactos) {
		
		Contactos c =leer(contactos.getCodigo());
		
		if(c==null)
			insertar(contactos);
		else
			actualizar(contactos);
	}
	
	public List<Contactos> listarContacto(){
		String jpql = "SELECT c FROM Contactos c";
		Query query = em.createQuery(jpql, Contactos.class);
		List<Contactos> list = query.getResultList();
		System.out.println("Lista "+list);
		return list;
	}
	
	public void guardaContacto(Contactos con) {
		Contactos c = leer(con.getCodigo());
		if(c==null) {
			guardaContacto(con);
		}else {
			actualizar(con);
		}
	}
}
