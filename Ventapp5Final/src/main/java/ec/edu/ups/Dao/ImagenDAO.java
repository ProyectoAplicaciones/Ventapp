package ec.edu.ups.Dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.Model.Imagen;

@Stateless
public class ImagenDAO {
	
	@Inject
	EntityManager em;
	
	public void insertar(Imagen img){
		em.persist(img);
	}
	
	public Imagen leer(String nombre) {
		Imagen img = em.find(Imagen.class, nombre);
		return img;
	}
	
	public void actualizar(Imagen img){
		em.merge(img);
	}
	
	public void borrar(String nombre){
		em.remove(leer(nombre));
	}
	
	public void guardar(Imagen im){
		Imagen img = leer(im.getNombreImagen());
		if(img==null)
			insertar(im);
		else
			actualizar(im);
	}
	
	public List<Imagen> listadoImagenes(){
		String sql = "SELECT n FROM Imagen n";
		Query q =em.createQuery(sql,Imagen.class );
		List<Imagen> catalogos = q.getResultList();
		return catalogos;
	}
}
