package ec.edu.ups.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.Dao.SectorDAO;
import ec.edu.ups.Model.Sector;





@ManagedBean
@SessionScoped
public class SectorController {
	
	private Sector sector;
	
	//Lista de ninos
	private List<Sector> listSectores;
	
	@Inject
	private SectorDAO sectorDao;
	
	@PostConstruct
	public void init(){
		sector = new Sector();
		listSectores = sectorDao.getSectores();
	}

	
	
	public Sector getSector() {
		return sector;
	}



	public void setSector(Sector sector) {
		this.sector = sector;
	}



	public List<Sector> getListSectores() {
		return listSectores;
	}



	public void setListSectores(List<Sector> listSectores) {
		this.listSectores = listSectores;
	}



	public SectorDAO getSectorDao() {
		return sectorDao;
	}



	public void setSectorDao(SectorDAO sectorDao) {
		this.sectorDao = sectorDao;
	}



	/**
	 * Metodo para guardar un nuevo registro de un Sector
	 * @return
	 */
	public String guardarSector(){
		sectorDao.save(sector);
		init();
		return null;
	}
	
	/**
	 * Meto para elminar un registro del objeto Sector
	 * @param id para identificar que registro eliminar
	 * @return
	 */
	public String eliminarSector(int id){
		sectorDao.borrar(id);
		init();
		return null;
	}
	
	/**
	 * Metodo para actualizar los datos de un niño
	 * @param id identifica que registro de niño quiere actualizar 
	 * @return
	 */
	public String actualizarSector(int id){
		 Sector sector = sectorDao.getSector(id);
		 this.sector=sector;
		return null;
	}

}
