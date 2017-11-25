package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Rol;
@Stateless
public class RolDao {
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Rol rol) {
		Rol r =leer(rol.getCodigo());
		
		System.out.println(rol.getCodigo());
		if(r==null)
			insertar(rol);
		else
			actualizar(rol);
	
	}	
	
	
	public void insertar(Rol rol) {	
		em.persist(rol);
	}
	
	
	public void actualizar(Rol rol) {
		em.merge(rol);
	}

	
	public void eliminar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Rol leer(int codigo) {
		Rol r=em.find(Rol.class, codigo);
		
		return r;
	}
	
	public List<Rol> listadoRoles(){
		String jpql = "Select p From Rol p";// p es un alias
		Query query = em.createQuery(jpql,Rol.class);
		List<Rol> listado = query.getResultList();
		
		
		System.out.println(listado.size());
		return listado;
		
	}
	
	
	

}
