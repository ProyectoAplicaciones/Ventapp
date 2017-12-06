package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import ec.edu.ups.Dao.CategoriaDao;
import ec.edu.ups.Model.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaController {


		private Categoria categoria;
		private List<Categoria> listCategorias;
		private int id;
		
		@Inject
		private CategoriaDao categoriaDao;
		
		@PostConstruct
		public void init() {
			
			categoria = new Categoria();
			loadCategorias();
			
		}
		
		
		public String guardar() {
			
			categoriaDao.guardar(categoria);
			categoria = new Categoria();
		
			
			
			return "Categorias";
		}

		public String eliminar (int codigo) {
			
			
			try {
				categoriaDao.eliminar(codigo);
			}
			catch (Exception e) {

				System.out.println("EERORRORO");
					
			}
			return "Categorias";
		}
		
		
		public String loadDatosEditar(int codigo) {
			
			categoria =categoriaDao.leer(codigo);
			return"CategoriasEditar";
			
		}

		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
			loadDatosEditar(id);
		}


		
		
		
		public List<Categoria> getListCategorias() {
			return listCategorias;
		}


		public void setListCategorias(List<Categoria> listCategorias) {
			this.listCategorias = listCategorias;
		}


		public Categoria getCategoria() {
			return categoria;
		}


		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
	
		public void loadCategorias() {
			listCategorias=categoriaDao.listadoCategoria();
		}
		
}
