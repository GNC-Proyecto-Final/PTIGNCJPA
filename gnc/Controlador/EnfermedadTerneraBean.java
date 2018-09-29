package Controlador;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import DAO.DAOEnfermedadTernerasBean;
import entidades.EnfermedadTernera;
import excepciones.GNCException;



/**
 * Session Bean implementation class EnfermedadTerneraBean
 */
@Stateless
@LocalBean
public class EnfermedadTerneraBean implements EnfermedadTerneraBeanRemote {
	@EJB
	DAOEnfermedadTernerasBean daoEnfermedadTerneraBean;
    /**
     * Default constructor. 
     */
    public EnfermedadTerneraBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public  boolean crearTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException {
    	boolean creado = false;
    	try {
    		if(!obtenerTerneraEnfermaFechaExiste(enfermedadTernera)){
    			daoEnfermedadTerneraBean.crearEnfermedadTernera(enfermedadTernera);
    			creado = true;
    		}
			
		} catch (Exception e) {
			// aca va el codigo si falla
			e.getMessage();
			
		}
    	return creado;
    }
    @Override
    public  boolean editarTerneraEnferma(EnfermedadTernera enfermedadTernera)throws GNCException {
    	boolean creado = false;
    	try {
    		
    			daoEnfermedadTerneraBean.editarEnfermedadTernera(enfermedadTernera);
    			creado = true;
			
		} catch (Exception e) {
			// aca va el codigo si falla
			e.getMessage();
			
		}
    	return creado;
    }
    @Override
	public List<EnfermedadTernera> obtenerTodasEnfermedadesTerneras(){
    	List<EnfermedadTernera> enf= null;
    	
    	enf = (List<EnfermedadTernera>) daoEnfermedadTerneraBean.obtenerTodasEnfermedadesTerneras();
    	return enf;
	}
	
    @Override
	public List<EnfermedadTernera> obtenerInformeTodasEnfermedadesTerneras(){
    	List<EnfermedadTernera> enf= null;
    	
    	enf = (List<EnfermedadTernera>) daoEnfermedadTerneraBean.obtenerTodasEnfermedadesTerneras();
    	 Collections.sort(enf,EnfermedadTernera.comparar);
    	
    	return enf;
	}
    
	 @Override
	 public boolean obtenerTerneraEnfermaFechaExiste(EnfermedadTernera enfermedadTernera){
    	boolean enfermTer = daoEnfermedadTerneraBean.obtenerTerneraEnfermaFechaExiste(enfermedadTernera);
		if(enfermTer == false)
			return false;
		else
			return true;
    }
	 @Override
	 public EnfermedadTernera obtenerTerneraEnfermaFecha(EnfermedadTernera enfermedadTernera){
		 EnfermedadTernera enfermTer;
		 	enfermTer = daoEnfermedadTerneraBean.obtenerTerneraEnfermaFecha(enfermedadTernera);
			return enfermTer;
	    }
	 @Override
		public boolean existeEnfermedadEnTernaraEnfermedad(long idTernera){
			
			boolean enferm = daoEnfermedadTerneraBean.obtenerTerneraEnfermaExiste(idTernera);
			if(enferm == false)
				return false;
			else
				return true;
		}


}
