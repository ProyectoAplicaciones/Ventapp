package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Provincia;


@Stateless 
public class ProvinciaDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void guardar(Provincia p){
		
		Provincia aux = leer(p.getCodigo());
		if (aux!=null){
			actualizar(p);
		}else{
			insertar(p);
		}
		
	}
	
	public void insertar(Provincia p){
		
		em.persist(p);
		
	}
	
	public void actualizar (Provincia p){
		
		em.merge(p);
		
		
	}
	
	public void borrar (int id){
		Provincia p = leer(id);
		em.remove(p);
		
	}

	
	public Provincia leer (int id){
		Provincia p = em.find(Provincia.class, id);
		
		return p;
		
	}
	
	public List<Provincia> listaProvincias(){
		//obtetiene todas las provincias
		Query query = em.createQuery("SELECT p FROM Provincia p",Provincia.class);
		List<Provincia> listado = query.getResultList();
		return listado;
	}
	
	public List<Provincia> getProvincias(String prov){
		String sql = "SELECT a FROM Provincia a "
				+ "WHERE nombre =?";
		Query q = em.createQuery(sql,Provincia.class);
		q.setParameter(1, prov);
		List<Provincia> admin = q.getResultList();
		System.out.println(prov + " Tamaño  "+admin.size());
		return admin;
	}
	
}
