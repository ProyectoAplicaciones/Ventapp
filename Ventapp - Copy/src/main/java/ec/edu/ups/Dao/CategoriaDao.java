package ec.edu.ups.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Model.Categoria;
@Stateless
public class CategoriaDao {
	
	

		
		@Inject 
		private EntityManager em;
		
		
		public void guardar(Categoria categoria) {
			Categoria c =leer(categoria.getCodigo());
			
			System.out.println(categoria.getCodigo());
			if(c==null)
				insertar(categoria);
			else
				actualizar(categoria);
		
		}	
		
		
		public void insertar(Categoria categoria) {	
			em.persist(categoria);
		}
		
		
		public void actualizar(Categoria categoria) {
			em.merge(categoria);
		}

		
		public void eliminar(int codigo) {
			em.remove(leer(codigo));
		}
		
		public Categoria leer(int codigo) {
			Categoria c=em.find(Categoria.class, codigo);
			
			return c;
		}
		
		public List<Categoria> listadoCategoria(){
			String jpql = "Select p From Rol p";// p es un alias
			Query query = em.createQuery(jpql,Categoria.class);
			List<Categoria> listado = query.getResultList();
			
			
			System.out.println(listado.size());
			return listado;
			
		}
		
		
		
	
	
	
	

}
