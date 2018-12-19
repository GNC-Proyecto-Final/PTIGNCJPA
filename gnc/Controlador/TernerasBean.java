package Controlador;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import DAO.DAOTernerasBean;
import entidades.Ternera;


/**
 * Session Bean implementation class TernerasBean
 */
@Stateless
@LocalBean
public class TernerasBean implements TernerasBeanRemote {
	@EJB
	DAOTernerasBean daoTernerasBean;
    /**
     * Default constructor. 
     */
    public TernerasBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public List<Ternera> obtenerTodasTerneras(){
    	List<Ternera> enf= null;
    	
    	enf = (List<Ternera>) daoTernerasBean.obtenerTodasTerneras();
    	return enf;
	}
    @Override
    public Ternera obtenerTerneraPorId(long idTernera){
		return daoTernerasBean.obtenerTerneraId(idTernera);
	}
    
    @Override
    public Ternera findTerneraPorId(long idTernera){
		return daoTernerasBean.obtenerTerneraId(idTernera);
	}
    @Override
    public Ternera obtenerTerneraNroCaravana(long idCaravana){
		return daoTernerasBean.obtenerTerneraNroCaravana(idCaravana);
	}
}
