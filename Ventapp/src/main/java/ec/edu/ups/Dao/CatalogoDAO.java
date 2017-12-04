package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Catalogo;

@Stateless
public class CatalogoDAO {

	@Inject
	EntityManager em;
	
	public void insertar(Catalogo cat){
		em.persist(cat);
	}
	
	public Catalogo leer(String nombre) {
		Catalogo c = em.find(Catalogo.class, nombre);
		return c;
	}
	
	public void actualizar(Catalogo cat){
		em.merge(cat);
	}
	
	public void borrar(String nombre){
		em.remove(leer(nombre));
	}
	
	public void guardar(Catalogo cat){
		Catalogo c = leer(cat.getNombreCatalogo());
		if(c==null)
			insertar(cat);
		else
			actualizar(cat);
	}
	
	public List<Catalogo> getCatalogos(){
		String sql = "SELECT n FROM Catalogo n";
		Query q =em.createQuery(sql,Catalogo.class );
		List<Catalogo> catalogos = q.getResultList();
		return catalogos;
	}
	
}
